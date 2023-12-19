package org.example.models.placeholder.comment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.example.models.BaseDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDto extends BaseDto {

    @JsonProperty(value = "postId", access = JsonProperty.Access.READ_WRITE)
    private Integer postId;
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_WRITE)
    private Integer id;
    @JsonProperty(value = "name", access = JsonProperty.Access.READ_WRITE)
    private String name;
    @JsonProperty(value = "email", access = JsonProperty.Access.READ_WRITE)
    private String email;
    @JsonProperty(value = "body", access = JsonProperty.Access.READ_WRITE)
    private String body;

    public Integer getPostId() {
        return postId;
    }

    public CommentDto setPostId(Integer postId) {
        this.postId = postId;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public CommentDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CommentDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CommentDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getBody() {
        return body;
    }

    public CommentDto setBody(String body) {
        this.body = body;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CommentDto that = (CommentDto) o;

        return new EqualsBuilder().append(postId, that.postId)
            .append(id, that.id)
            .append(name, that.name)
            .append(email, that.email)
            .append(body, that.body)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(postId)
            .append(id)
            .append(name)
            .append(email)
            .append(body)
            .toHashCode();
    }

}
