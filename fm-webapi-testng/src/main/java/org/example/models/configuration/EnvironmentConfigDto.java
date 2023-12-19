package org.example.models.configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.example.models.BaseDto;

@JsonIgnoreProperties(ignoreUnknown = false)
public class EnvironmentConfigDto extends BaseDto {

    @JsonProperty(value = "apiUrl", access = JsonProperty.Access.READ_WRITE)
    private String apiUrl;
    @JsonProperty(value = "apiPort", access = JsonProperty.Access.READ_WRITE)
    private Integer apiPort;
    @JsonProperty(value = "apiBasePath", access = JsonProperty.Access.READ_WRITE)
    private String apiBasePath;

    public String getApiUrl() {
        return apiUrl;
    }

    public EnvironmentConfigDto setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
        return this;
    }

    public Integer getApiPort() {
        return apiPort;
    }

    public EnvironmentConfigDto setApiPort(Integer apiPort) {
        this.apiPort = apiPort;
        return this;
    }

    public String getApiBasePath() {
        return apiBasePath;
    }

    public EnvironmentConfigDto setApiBasePath(String apiBasePath) {
        this.apiBasePath = apiBasePath;
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

        EnvironmentConfigDto that = (EnvironmentConfigDto) o;

        return new EqualsBuilder().append(apiUrl, that.apiUrl)
            .append(apiPort, that.apiPort)
            .append(apiBasePath, that.apiBasePath)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(apiUrl)
            .append(apiPort)
            .append(apiBasePath)
            .toHashCode();
    }
}
