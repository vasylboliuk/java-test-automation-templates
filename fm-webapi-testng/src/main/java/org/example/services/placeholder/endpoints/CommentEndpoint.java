package org.example.services.placeholder.endpoints;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.models.enums.HttpStatus;
import org.example.models.placeholder.comment.CommentDto;
import org.example.services.common.AbstractWebEndpoint;

public class CommentEndpoint extends AbstractWebEndpoint {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String COMMENTS_END = "/comments";
    private static final String COMMENTS_RESOURCE_END = "/comments/{commentID}";

    public CommentEndpoint(RequestSpecification specification) {
        super(specification);
    }

    public CommentDto create(CommentDto commentDto) {
        return create(commentDto, HttpStatus.CREATED)
            .extract().as(CommentDto.class);
    }

    public ValidatableResponse create(CommentDto commentDto, HttpStatus status) {
        LOGGER.info("Create new Comment");
        return post(
            this.specification,
            COMMENTS_END,
            commentDto)
            .statusCode(status.getCode());
    }

    public CommentDto update(int id, CommentDto commentDto) {
        return update(commentDto, id, HttpStatus.OK)
            .extract().as(CommentDto.class);
    }

    public ValidatableResponse update(CommentDto commentDto, int id, HttpStatus status) {
        LOGGER.info("Update Comment by id [{}]", id);
        return put(
            this.specification,
            COMMENTS_RESOURCE_END,
            commentDto,
            id)
            .statusCode(status.getCode());
    }

    public CommentDto getById(int id) {
        return getById(id, HttpStatus.OK)
            .extract().as(CommentDto.class);
    }

    public ValidatableResponse getById(int id, HttpStatus status) {
        LOGGER.info("Get Comment by id [{}]", id);
        return get(
            this.specification,
            COMMENTS_RESOURCE_END,
            String.valueOf(id))
            .statusCode(status.getCode());
    }

    public List<CommentDto> getAll() {
        return List.of(getAll(HttpStatus.OK).extract().as(CommentDto[].class));
    }

    public ValidatableResponse getAll(HttpStatus status) {
        LOGGER.info("Get all Comments");
        ValidatableResponse response = get(this.specification, COMMENTS_END);
        response.statusCode(status.getCode());
        return response;
    }


}
