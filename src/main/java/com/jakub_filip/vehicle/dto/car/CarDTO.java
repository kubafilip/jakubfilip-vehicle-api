package com.jakub_filip.vehicle.dto.car;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class CarDTO {

    @JsonProperty("id")
    private UUID id;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("model")
    private String model;

}
