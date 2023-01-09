package com.jakub_filip.vehicle.controllers.api;

import com.jakub_filip.vehicle.dto.car.CarCreateRequestDTO;
import com.jakub_filip.vehicle.dto.car.CarDTO;
import com.jakub_filip.vehicle.dto.car.CarUpdateRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.UUID;

@Validated
public interface CarCommandApi {

    @RequestMapping(
        method = {RequestMethod.POST},
        value = {"/cars"},
        produces = {"application/json"},
        consumes = {"application/json"}
    )
    ResponseEntity<CarDTO> createCar(@Valid @RequestBody CarCreateRequestDTO carCreateRequestDTO);


    @RequestMapping(
        method = {RequestMethod.DELETE},
        value = {"/cars/{car-uuid}"}
    )
    ResponseEntity<Void> deleteCarById(@PathVariable("car-uuid") UUID carUuid);

    @RequestMapping(
        method = {RequestMethod.PUT},
        value = {"/cars/{car-uuid}"},
        produces = {"application/json"},
        consumes = {"application/json"}
    )
    ResponseEntity<CarDTO> updateCarById(@PathVariable("car-uuid") UUID carUuid, @Valid @RequestBody(required = false) CarUpdateRequestDTO carUpdateRequestDTO);


    @RequestMapping(
        method = {RequestMethod.PATCH},
        value = {"/cars/{car-uuid}/person/{person-uuid}"}
    )
    ResponseEntity<Void> assignCarToPersonById(@PathVariable("car-uuid") UUID carUuid, @PathVariable("person-uuid") UUID personUuid);
}
