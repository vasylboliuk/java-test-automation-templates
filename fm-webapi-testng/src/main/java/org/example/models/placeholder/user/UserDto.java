package org.example.models.placeholder.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.example.generators.Generator;
import org.example.models.BaseDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto extends BaseDto {

    @JsonProperty(value = "id", access = JsonProperty.Access.READ_WRITE)
    private String id;
    @JsonProperty(value = "name", access = JsonProperty.Access.READ_WRITE)
    private String name;
    @JsonProperty(value = "username", access = JsonProperty.Access.READ_WRITE)
    private String username;
    @JsonProperty(value = "email", access = JsonProperty.Access.READ_WRITE)
    private String email;
    @JsonProperty(value = "address", access = JsonProperty.Access.READ_WRITE)
    private AddressDto address;
    @JsonProperty(value = "phone", access = JsonProperty.Access.READ_WRITE)
    private String phone;
    @JsonProperty(value = "website", access = JsonProperty.Access.READ_WRITE)
    private String website;
    @JsonProperty(value = "company", access = JsonProperty.Access.READ_WRITE)
    private CompanyDto company;

    /**
     * Method using for Build new UserDto payload.
     */
    public static Builder newBuilder() {
        return new UserDto().new Builder();
    }


    public String getId() {
        return id;
    }

    public UserDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public AddressDto getAddress() {
        return address;
    }

    public UserDto setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public UserDto setWebsite(String website) {
        this.website = website;
        return this;
    }

    public CompanyDto getCompany() {
        return company;
    }

    public UserDto setCompany(CompanyDto company) {
        this.company = company;
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

        UserDto userDto = (UserDto) o;

        return new EqualsBuilder().append(id, userDto.id)
            .append(name, userDto.name)
            .append(username, userDto.username)
            .append(email, userDto.email)
            .append(address, userDto.address)
            .append(phone, userDto.phone)
            .append(website, userDto.website)
            .append(company, userDto.company)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id)
            .append(name)
            .append(username)
            .append(email)
            .append(address)
            .append(phone)
            .append(website)
            .append(company)
            .toHashCode();
    }

    public class Builder {

        private Builder() {
            UserDto.this.name = "Name " + Generator.randomString();
            UserDto.this.username = "UserName " + Generator.randomString();
        }

        public Builder withName(String name) {
            UserDto.this.name = name;
            return this;
        }

        public Builder withUserName(String userName) {
            UserDto.this.username = userName;
            return this;
        }

        public Builder withEmail(String email) {
            UserDto.this.email = email;
            return this;
        }

        public Builder withAddress(AddressDto address) {
            UserDto.this.address = address;
            return this;
        }

        public Builder withPhone(String phone) {
            UserDto.this.phone = phone;
            return this;
        }

        public Builder withWebsite(String website) {
            UserDto.this.website = website;
            return this;
        }

        public Builder withCompany(String name, String catchPhrase, String bs) {
            UserDto.this.company = new CompanyDto()
                .setName(name)
                .setBs(bs)
                .setCatchPhrase(catchPhrase);
            return this;
        }

        public UserDto build() {
            return UserDto.this;
        }

    }

}
