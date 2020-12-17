package com.asktao.web.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wcy
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeignErrorBody implements Serializable {
    private static final long serialVersionUID = 2194375101082130317L;

    @JsonProperty("error_description")
    private String errorDescription;

}
