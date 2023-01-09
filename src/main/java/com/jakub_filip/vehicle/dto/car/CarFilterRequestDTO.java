package com.jakub_filip.vehicle.dto.car;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jakub_filip.vehicle.dto.pagination.PageableMetadataDTO;
import lombok.Data;

@Data
public class CarFilterRequestDTO {

    @JsonProperty("brand")
    private String brand;
    @JsonProperty("model")
    private String model;
    @JsonProperty("pageRequest")
    private PageableMetadataDTO pageRequest;
}
