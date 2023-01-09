package com.jakub_filip.vehicle.dto.car;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CarUpdateRequestDTO {

    @JsonProperty("brand")
    private String brand;
    @JsonProperty("model")
    private String model;
}
