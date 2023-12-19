package org.example.config;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.models.configuration.EnvironmentConfigDto;
import org.example.utils.DtoConverter;
import org.example.utils.FileUtil;

public class EnvironmentProvider {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String ENVIRONMENT_TEMPLATE = "/environments/%s/%s";
    private static final String ENVIRONMENTS_FILE = "web_service_config.json";
    private static final ThreadLocal<EnvironmentProvider> LOADER = new ThreadLocal<>();
    private Map<String, EnvironmentConfigDto> serviceSetting;

    private EnvironmentProvider() {
        // default private constructor
    }

    public static EnvironmentProvider provideEnvironment() {
        if (LOADER.get() == null) {
            EnvironmentProvider loader = new EnvironmentProvider();
            loader.loadEnvironmentProperties();
            LOADER.set(loader);
        }
        return LOADER.get();
    }

    public EnvironmentConfigDto getSettings(String settingName) {
        return serviceSetting.get(settingName);
    }

    private void loadEnvironmentProperties() {
        String environment = MavenProperties.getCurrentEnvironment();
        if (StringUtils.isEmpty(environment)) {
            environment = "dev";
        }
        String envName = environment.toUpperCase();
        LOGGER.info("Automation tests run on Environment: [{}]", envName);

        final String environmentFile = String.format(ENVIRONMENT_TEMPLATE, environment, ENVIRONMENTS_FILE);
        LOGGER.debug("Read environments file from resources: [{}]", environmentFile);
        serviceSetting = DtoConverter.jsonFileToDto(environmentFile, new TypeReference<Map<String, EnvironmentConfigDto>>() { });
        Objects.requireNonNull(serviceSetting);
    }


}
