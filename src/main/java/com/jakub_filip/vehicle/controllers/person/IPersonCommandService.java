package com.jakub_filip.vehicle.controllers.person;

import com.jakub_filip.vehicle.dto.person.PersonCreateRequestDTO;
import com.jakub_filip.vehicle.dto.person.PersonDTO;
import com.jakub_filip.vehicle.dto.person.PersonUpdateRequestDTO;

import java.util.UUID;

public interface IPersonCommandService {
    PersonDTO createPerson(PersonCreateRequestDTO createPersonRequestDTO);

    void deletePersonById(UUID personUuid);

    PersonDTO updatePersonById(UUID personUuid, PersonUpdateRequestDTO personUpdateRequestDTO);

}
