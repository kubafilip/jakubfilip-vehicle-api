package com.jakub_filip.vehicle.controllers.api;

import com.jakub_filip.vehicle.dto.person.PersonCreateRequestDTO;
import com.jakub_filip.vehicle.dto.person.PersonDTO;
import com.jakub_filip.vehicle.dto.person.PersonUpdateRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.UUID;

@Validated
public interface PersonCommandApi {

    @RequestMapping(
        method = {RequestMethod.POST},
        value = {"/person"},
        produces = {"application/json"},
        consumes = {"application/json"}
    )
    ResponseEntity<PersonDTO> createPerson(@Valid @RequestBody(required = false) PersonCreateRequestDTO personCreateRequestDTO);

    @RequestMapping(
        method = {RequestMethod.DELETE},
        value = {"/person/{person-uuid}"}
    )
    ResponseEntity<Void> deletePersonById(@PathVariable("person-uuid") UUID personUuid);

    @RequestMapping(
        method = {RequestMethod.PUT},
        value = {"/person/{person-uuid}"},
        produces = {"application/json"},
        consumes = {"application/json"}
    )
    ResponseEntity<PersonDTO> updatePersonById(@PathVariable("person-uuid") UUID personUuid, @Valid @RequestBody(required = false) PersonUpdateRequestDTO personUpdateRequestDTO);
}
