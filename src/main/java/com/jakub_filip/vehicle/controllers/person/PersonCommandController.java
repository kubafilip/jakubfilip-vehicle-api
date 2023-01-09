package com.jakub_filip.vehicle.controllers.person;

import com.jakub_filip.vehicle.controllers.api.PersonCommandApi;
import com.jakub_filip.vehicle.dto.person.PersonCreateRequestDTO;
import com.jakub_filip.vehicle.dto.person.PersonDTO;
import com.jakub_filip.vehicle.dto.person.PersonUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PersonCommandController implements PersonCommandApi {

    private final IPersonCommandService service;

    @Override
    public ResponseEntity<PersonDTO> createPerson(@Valid PersonCreateRequestDTO personCreateRequestDTO) {
        log.info("In createPerson method");
        log.info("personCreateRequestDTO.name: {}");
        PersonDTO personDTO = service.createPerson(personCreateRequestDTO);
        return status(HttpStatus.CREATED).body(personDTO);
    }

    @Override
    public ResponseEntity<Void> deletePersonById(UUID personUuid) {
        service.deletePersonById(personUuid);
        return status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<PersonDTO> updatePersonById(UUID personUuid, @Valid PersonUpdateRequestDTO personUpdateRequestDTO) {
        PersonDTO personDTO = service.updatePersonById(personUuid, personUpdateRequestDTO);
        return status(HttpStatus.OK).body(personDTO);
    }

}
