package org.example.services.placeholder;

import io.restassured.specification.RequestSpecification;
import org.example.services.common.AbstractWebService;
import org.example.services.placeholder.endpoints.CommentEndpoint;
import org.example.services.placeholder.endpoints.UserEndpoint;

public class JsonPlaceHolderApi extends AbstractWebService {

    private static final String API_KEY = "placeholderService";
    private RequestSpecification requestSpecification;

    public JsonPlaceHolderApi() {
        super(API_KEY);
        initRequestSpecification();
    }


    protected void initRequestSpecification() {
        requestSpecification = getDefaultSpecification();
    }

    public UserEndpoint user() {
        return new UserEndpoint(requestSpecification);
    }

    public CommentEndpoint comment() {
        return new CommentEndpoint(requestSpecification);
    }

}
