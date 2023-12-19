package org.example.models.placeholder.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.example.models.BaseDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressGeoDto extends BaseDto {

    @JsonProperty(value = "lat", access = JsonProperty.Access.READ_WRITE)
    private String lat;
    @JsonProperty(value = "lng", access = JsonProperty.Access.READ_WRITE)
    private String lng;

    public String getLat() {
        return lat;
    }

    public AddressGeoDto setLat(String lat) {
        this.lat = lat;
        return this;
    }

    public String getLng() {
        return lng;
    }

    public AddressGeoDto setLng(String lng) {
        this.lng = lng;
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

        AddressGeoDto that = (AddressGeoDto) o;

        return new EqualsBuilder().append(lat, that.lat).append(lng, that.lng).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(lat)
            .append(lng)
            .toHashCode();
    }

}
