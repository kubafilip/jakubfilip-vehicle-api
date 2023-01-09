package com.jakub_filip.vehicle.controllers.car;

import com.jakub_filip.vehicle.dto.car.CarCreateRequestDTO;
import com.jakub_filip.vehicle.dto.car.CarDTO;
import com.jakub_filip.vehicle.dto.car.CarUpdateRequestDTO;

import java.util.UUID;

public interface ICarCommandService {

    CarDTO createCar(CarCreateRequestDTO createCarRequestDTO);

    CarDTO updateCarById(UUID carUuid, CarUpdateRequestDTO carUpdateRequestDTO);

    void deleteCarById(UUID carUuid);

    void assignCarToPersonById(UUID carUuid, UUID personUuid);

}
