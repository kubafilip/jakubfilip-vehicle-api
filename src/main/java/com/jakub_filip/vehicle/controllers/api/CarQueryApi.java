package com.jakub_filip.vehicle.controllers.api;

import com.jakub_filip.vehicle.dto.car.CarDTO;
import com.jakub_filip.vehicle.dto.car.CarFilterRequestDTO;
import com.jakub_filip.vehicle.dto.car.CarFilterResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.UUID;

@Validated
public interface CarQueryApi {

    @RequestMapping(
        method = {RequestMethod.GET},
        value = {"/cars/{car-uuid}"},
        produces = {"application/json"}
    )
    ResponseEntity<CarDTO> getCarById(@PathVariable("car-uuid") UUID carUuid);

    @RequestMapping(
        method = {RequestMethod.POST},
        value = {"/cars/search"},
        produces = {"application/json"},
        consumes = {"application/json"}
    )
    ResponseEntity<CarFilterResponseDTO> searchCars(@Valid @RequestBody(required = false) CarFilterRequestDTO carFilterRequestDTO);
}
