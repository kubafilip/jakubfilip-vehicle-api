package com.jakub_filip.vehicle.controllers.api;

import com.jakub_filip.vehicle.dto.person.PersonDTO;
import com.jakub_filip.vehicle.dto.person.PersonFilterRequestDTO;
import com.jakub_filip.vehicle.dto.person.PersonFilterResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.UUID;

@Validated
public interface PersonQueryApi {

    @RequestMapping(
        method = {RequestMethod.GET},
        value = {"/person/{person-uuid}"},
        produces = {"application/json"}
    )
    ResponseEntity<PersonDTO> getPersonById(@PathVariable("person-uuid") UUID personId);


    @RequestMapping(
        method = {RequestMethod.POST},
        value = {"/person/search"},
        produces = {"application/json"},
        consumes = {"application/json"}
    )
    ResponseEntity<PersonFilterResponseDTO> searchPerson(@Valid @RequestBody(required = false) PersonFilterRequestDTO personFilterRequestDTO);
}
