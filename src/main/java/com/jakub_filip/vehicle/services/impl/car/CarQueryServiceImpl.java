package com.jakub_filip.vehicle.services.impl.car;

import com.jakub_filip.vehicle.controllers.car.ICarQueryService;
import com.jakub_filip.vehicle.dao.repositories.CarRepository;
import com.jakub_filip.vehicle.dto.car.CarDTO;
import com.jakub_filip.vehicle.dto.car.CarFilterRequestDTO;
import com.jakub_filip.vehicle.dto.car.CarFilterResponseDTO;
import com.jakub_filip.vehicle.exceptions.NotFoundObjectException;
import com.jakub_filip.vehicle.mappers.car.CarMapper;
import com.jakub_filip.vehicle.services.searching.filter.car.CarFilter;
import com.jakub_filip.vehicle.services.searching.finder.car.ICarFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarQueryServiceImpl implements ICarQueryService {

    private final CarRepository repository;
    private final CarMapper mapper;
    private final ICarFinder finder;

    @Override
    public CarDTO getCarById(UUID carUuid) {
        return repository.findById(carUuid).map(mapper::toDTO).orElseThrow(NotFoundObjectException::new);
    }

    @Override
    public CarFilterResponseDTO searchCars(CarFilterRequestDTO carFilterRequestDTO) {
        CarFilter carFilter = mapper.toFilterFromFilterRequestDTO(carFilterRequestDTO);
        return finder.find(carFilterRequestDTO, carFilter);
    }
}
