package com.jakub_filip.vehicle.controllers.car;

import com.jakub_filip.vehicle.controllers.api.CarQueryApi;
import com.jakub_filip.vehicle.dto.car.CarDTO;
import com.jakub_filip.vehicle.dto.car.CarFilterRequestDTO;
import com.jakub_filip.vehicle.dto.car.CarFilterResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class CarQueryController implements CarQueryApi {

    private final ICarQueryService service;

    @Override
    public ResponseEntity<CarDTO> getCarById(UUID carUuid) {
        CarDTO carDTO = service.getCarById(carUuid);
        return ok(carDTO);
    }

    @Override
    public ResponseEntity<CarFilterResponseDTO> searchCars(@Valid CarFilterRequestDTO carFilterRequestDTO) {
        CarFilterResponseDTO responseDTO = service.searchCars(carFilterRequestDTO);
        return ok(responseDTO);
    }
}
