package com.jakub_filip.vehicle.controllers.car;

import com.jakub_filip.vehicle.dto.car.CarDTO;
import com.jakub_filip.vehicle.dto.car.CarFilterRequestDTO;
import com.jakub_filip.vehicle.dto.car.CarFilterResponseDTO;

import java.util.UUID;

public interface ICarQueryService {

    CarDTO getCarById(UUID carUuid);

    CarFilterResponseDTO searchCars(CarFilterRequestDTO carFilterRequestDTO);
}
