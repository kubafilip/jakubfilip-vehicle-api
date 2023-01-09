package com.jakub_filip.vehicle.services.searching.finder.person;


import com.jakub_filip.vehicle.dto.person.PersonFilterRequestDTO;
import com.jakub_filip.vehicle.dto.person.PersonFilterResponseDTO;
import com.jakub_filip.vehicle.services.searching.filter.person.PersonFilter;

public interface IPersonFinder {
    PersonFilterResponseDTO find(PersonFilterRequestDTO personFilterRequestDTO, PersonFilter personFilter);
}
