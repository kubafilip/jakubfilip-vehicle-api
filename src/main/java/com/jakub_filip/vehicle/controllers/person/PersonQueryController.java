package com.jakub_filip.vehicle.controllers.person;

import com.jakub_filip.vehicle.controllers.api.PersonQueryApi;
import com.jakub_filip.vehicle.dto.person.PersonDTO;
import com.jakub_filip.vehicle.dto.person.PersonFilterRequestDTO;
import com.jakub_filip.vehicle.dto.person.PersonFilterResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class PersonQueryController implements PersonQueryApi {

    private final IPersonQueryService service;

    @Override
    public ResponseEntity<PersonDTO> getPersonById(UUID personUuid) {
        PersonDTO personDTO = service.getPersonById(personUuid);
        return ok(personDTO);
    }

    @Override
    public ResponseEntity<PersonFilterResponseDTO> searchPerson(@Valid PersonFilterRequestDTO personFilterRequestDTO) {
        PersonFilterResponseDTO responseDTO = service.searchPersons(personFilterRequestDTO);
        return ok(responseDTO);
    }
}
