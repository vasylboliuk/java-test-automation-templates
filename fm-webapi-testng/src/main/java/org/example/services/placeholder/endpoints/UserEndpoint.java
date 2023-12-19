package org.example.services.placeholder.endpoints;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.models.enums.HttpStatus;
import org.example.models.placeholder.user.UserDto;
import org.example.services.common.AbstractWebEndpoint;

public class UserEndpoint extends AbstractWebEndpoint {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String USERS_END = "/users";
    private static final String USERS_RESOURCE_END = "/users/{userID}";

    public UserEndpoint(RequestSpecification specification) {
        super(specification);
    }

    public UserDto create(UserDto userDto) {
        return create(userDto, HttpStatus.CREATED)
            .extract().as(UserDto.class);
    }

    public ValidatableResponse create(UserDto userDto, HttpStatus status) {
        LOGGER.info("Create new User");
        return post(
            this.specification,
            USERS_END,
            userDto)
            .statusCode(status.getCode());
    }

    public UserDto update(int id, UserDto userDto) {
        return update(userDto, id, HttpStatus.OK)
            .extract().as(UserDto.class);
    }

    public ValidatableResponse update(UserDto userDto, int id, HttpStatus status) {
        LOGGER.info("Update User by id [{}]", id);
        return put(
            this.specification,
            USERS_RESOURCE_END,
            userDto,
            id)
            .statusCode(status.getCode());
    }

    public UserDto getById(String id) {
        return getById(id, HttpStatus.OK)
            .extract().as(UserDto.class);
    }

    public ValidatableResponse getById(String id, HttpStatus status) {
        LOGGER.info("Get User by id [{}]", id);
        return get(
            this.specification,
            USERS_RESOURCE_END,
            id)
            .statusCode(status.getCode());
    }

    public List<UserDto> getAll() {
        return List.of(getAll(HttpStatus.OK).extract().as(UserDto[].class));
    }

    public ValidatableResponse getAll(HttpStatus status) {
        LOGGER.info("Get all Users");
        ValidatableResponse response = get(this.specification, USERS_END);
        response.statusCode(status.getCode());
        return response;
    }

}
