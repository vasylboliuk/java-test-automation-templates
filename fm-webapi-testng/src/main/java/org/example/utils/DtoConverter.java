package org.example.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.io.InputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;

public class DtoConverter {

    private static final Logger LOGGER = LogManager.getLogger();

    private DtoConverter() {
        // default private constructor, no object creation
    }

    /**
     * Convert dto to json string.
     *
     * @param dtoClass input object
     * @return String json
     */
    public static String dtoToJsonString(Object dtoClass) {
        ObjectMapper mapper = new ObjectMapper();
        return writeAsString(dtoClass, mapper, JsonInclude.Include.NON_NULL);
    }

    /**
     * Convert dto to pretty json output.
     *
     * @param dtoClass - source
     * @return string json
     */
    public static String dtoToPrettyJsonString(Object dtoClass) {
        String result = Strings.EMPTY;
        ObjectMapper mapper = new ObjectMapper();
        try {
            result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dtoClass);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
        }
        return result;
    }

    private static String writeAsString(Object dtoClass, ObjectMapper mapper, JsonInclude.Include option) {
        String result = Strings.EMPTY;
        try {
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            mapper.setSerializationInclusion(option);
            result = mapper.writeValueAsString(dtoClass);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
        }
        return result;
    }

    /**
     * Convert string to dto.
     * @param dtoClass - source
     * @param content  - target
     * @param <T> - T any type suitable for deserialization, list, map, dto
     * @return T
     */
    public static <T> T stringToDto(Class<T> dtoClass, String content) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return objectMapper.readValue(content, dtoClass);
        } catch (IOException e) {
            LOGGER.error(e);
            return null;
        }
    }

    /**
     * Read a json file and deserialize it using TypeReference.
     *
     * @param filePath      path to json file
     * @param typeReference TypeReference describing an object
     * @param <T>           T any type suitable for deserialization, list, map, dto
     * @return T
     */
    public static <T> T jsonFileToDto(String filePath, TypeReference<T> typeReference) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try (InputStream inputStream = FileUtil.getFileInputStream(filePath, DtoConverter.class)) {
            return mapper.readValue(inputStream, typeReference);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return null;
    }

}
