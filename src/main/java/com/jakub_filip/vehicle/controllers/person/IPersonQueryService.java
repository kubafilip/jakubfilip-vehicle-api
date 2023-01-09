package com.jakub_filip.vehicle.controllers.person;



import com.jakub_filip.vehicle.dto.person.PersonDTO;
import com.jakub_filip.vehicle.dto.person.PersonFilterRequestDTO;
import com.jakub_filip.vehicle.dto.person.PersonFilterResponseDTO;

import java.util.UUID;

public interface IPersonQueryService {
    PersonDTO getPersonById(UUID personUuid);

    PersonFilterResponseDTO searchPersons(PersonFilterRequestDTO personFilterRequestDTO);
}
