package org.example.models.placeholder.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.example.models.BaseDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto extends BaseDto {

    @JsonProperty(value = "street", access = JsonProperty.Access.READ_WRITE)
    private String street;
    @JsonProperty(value = "suite", access = JsonProperty.Access.READ_WRITE)
    private String suite;
    @JsonProperty(value = "city", access = JsonProperty.Access.READ_WRITE)
    private String city;
    @JsonProperty(value = "zipcode", access = JsonProperty.Access.READ_WRITE)
    private String zipcode;
    @JsonProperty(value = "geo", access = JsonProperty.Access.READ_WRITE)
    private AddressGeoDto geo;

    public String getStreet() {
        return street;
    }

    public AddressDto setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getSuite() {
        return suite;
    }

    public AddressDto setSuite(String suite) {
        this.suite = suite;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZipcode() {
        return zipcode;
    }

    public AddressDto setZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public AddressGeoDto getGeo() {
        return geo;
    }

    public AddressDto setGeo(AddressGeoDto geo) {
        this.geo = geo;
        return this;
    }

    @JsonIgnore
    public AddressDto setAddressGeo(String lat, String lng) {
        this.geo = new AddressGeoDto()
            .setLat(lat)
            .setLng(lng);
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

        AddressDto that = (AddressDto) o;

        return new EqualsBuilder().append(street, that.street)
            .append(suite, that.suite)
            .append(city, that.city)
            .append(zipcode, that.zipcode)
            .append(geo, that.geo)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(street)
            .append(suite)
            .append(city)
            .append(zipcode)
            .append(geo)
            .toHashCode();
    }


}
