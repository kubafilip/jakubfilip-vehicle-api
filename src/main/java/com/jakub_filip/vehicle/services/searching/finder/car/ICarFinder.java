package com.jakub_filip.vehicle.services.searching.finder.car;

import com.jakub_filip.vehicle.dto.car.CarFilterRequestDTO;
import com.jakub_filip.vehicle.dto.car.CarFilterResponseDTO;
import com.jakub_filip.vehicle.services.searching.filter.car.CarFilter;

public interface ICarFinder {
    CarFilterResponseDTO find(CarFilterRequestDTO carFilterRequestDTO, CarFilter carFilter);
}
