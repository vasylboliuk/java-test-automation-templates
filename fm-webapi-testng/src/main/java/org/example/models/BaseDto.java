package org.example.models;

import org.example.utils.DtoConverter;

public abstract class BaseDto {


    public String toJsonString() {
        return DtoConverter.dtoToJsonString(this);
    }

    public String toPrettyJsonString() {
        return DtoConverter.dtoToPrettyJsonString(this);
    }

    @Override
    public String toString() {
        return toJsonString();
    }

}
