package com.jakub_filip.vehicle.dto.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jakub_filip.vehicle.dto.car.CarDTO;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Data
public class PersonDTO {

    @JsonProperty("uuid")
    private UUID uuid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("email")
    private String email;
    @JsonProperty("cars")
    @Valid
    private List<CarDTO> cars = null;

}
