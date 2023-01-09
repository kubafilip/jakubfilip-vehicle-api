package com.jakub_filip.vehicle.controllers.car;

import com.jakub_filip.vehicle.controllers.api.CarCommandApi;
import com.jakub_filip.vehicle.dto.car.CarCreateRequestDTO;
import com.jakub_filip.vehicle.dto.car.CarDTO;
import com.jakub_filip.vehicle.dto.car.CarUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
public class CarCommandController implements CarCommandApi {

    private final ICarCommandService service;

    @Override
    public ResponseEntity<CarDTO> createCar(@Valid CarCreateRequestDTO createCarRequestDTO) {
        CarDTO carDTO = service.createCar(createCarRequestDTO);
        return status(HttpStatus.CREATED).body(carDTO);
    }

    @Override
    public ResponseEntity<Void> deleteCarById(UUID carUuid) {
        service.deleteCarById(carUuid);
        return status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<CarDTO> updateCarById(UUID carUuid, @Valid CarUpdateRequestDTO carUpdateRequestDTO) {
        CarDTO carDTO = service.updateCarById(carUuid, carUpdateRequestDTO);
        return status(HttpStatus.OK).body(carDTO);
    }

    @Override
    public ResponseEntity<Void> assignCarToPersonById(UUID carUuid, UUID personUuid) {
        service.assignCarToPersonById(carUuid, personUuid);
        return status(HttpStatus.NO_CONTENT).build();
    }

}
