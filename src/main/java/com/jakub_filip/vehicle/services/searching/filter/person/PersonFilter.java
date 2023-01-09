package com.jakub_filip.vehicle.services.searching.filter.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonFilter {

    String searchString;
    Integer minAge;
    Integer maxAge;

}
