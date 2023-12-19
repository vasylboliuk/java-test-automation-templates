package org.example.models.placeholder.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.example.models.BaseDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDto extends BaseDto {

    @JsonProperty(value = "name", access = JsonProperty.Access.READ_WRITE)
    private String name;
    @JsonProperty(value = "catchPhrase", access = JsonProperty.Access.READ_WRITE)
    private String catchPhrase;
    @JsonProperty(value = "bs", access = JsonProperty.Access.READ_WRITE)
    private String bs;

    public String getName() {
        return name;
    }

    public CompanyDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public CompanyDto setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
        return this;
    }

    public String getBs() {
        return bs;
    }

    public CompanyDto setBs(String bs) {
        this.bs = bs;
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

        CompanyDto that = (CompanyDto) o;

        return new EqualsBuilder().append(name, that.name)
            .append(catchPhrase, that.catchPhrase)
            .append(bs, that.bs)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(name)
            .append(catchPhrase)
            .append(bs)
            .toHashCode();
    }

}
