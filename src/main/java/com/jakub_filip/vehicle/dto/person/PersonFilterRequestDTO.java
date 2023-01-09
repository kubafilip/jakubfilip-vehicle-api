package com.jakub_filip.vehicle.dto.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jakub_filip.vehicle.dto.pagination.PageableMetadataDTO;
import lombok.Data;

@Data
public class PersonFilterRequestDTO {
    @JsonProperty("searchString")
    private String searchString;
    @JsonProperty("minAge")
    private Integer minAge;
    @JsonProperty("maxAge")
    private Integer maxAge;
    @JsonProperty("pageRequest")
    private PageableMetadataDTO pageRequest;
}
