package org.example.services;

import org.example.services.placeholder.JsonPlaceHolderApi;

public class Services {

    private Services() {
        // default private constructor
    }

    public static JsonPlaceHolderApi placeholderApi() {
        return new JsonPlaceHolderApi();
    }

}
