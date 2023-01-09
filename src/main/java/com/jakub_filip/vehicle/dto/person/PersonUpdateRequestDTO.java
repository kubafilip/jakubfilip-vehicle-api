package com.jakub_filip.vehicle.dto.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonUpdateRequestDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("email")
    private String email;
}
