package com.jakub_filip.vehicle.services.searching.finder.car;


import com.jakub_filip.vehicle.dao.repositories.CarRepository;
import com.jakub_filip.vehicle.dao.specification.CarSpecification;
import com.jakub_filip.vehicle.dto.car.CarDTO;
import com.jakub_filip.vehicle.dto.car.CarFilterRequestDTO;
import com.jakub_filip.vehicle.dto.car.CarFilterResponseDTO;
import com.jakub_filip.vehicle.entities.car.CarEntity_;
import com.jakub_filip.vehicle.mappers.car.CarMapper;
import com.jakub_filip.vehicle.services.searching.AbstractFinder;
import com.jakub_filip.vehicle.services.searching.filter.car.CarFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarFinderImpl extends AbstractFinder implements ICarFinder {

    private final CarMapper mapper;
    private final CarRepository repository;

    private static final List<String> SORT_FIELDS = List.of(CarEntity_.BRAND);

    @Override
    public CarFilterResponseDTO find(CarFilterRequestDTO carFilterRequestDTO, CarFilter carFilter) {
        Page<CarDTO> results = getSearchResult(carFilterRequestDTO, carFilter);
        return new CarFilterResponseDTO()
            .cars(results.getContent())
            .metadata(paginatedMetadataFromPage(results));
    }

    private Page<CarDTO> getSearchResult(
        CarFilterRequestDTO carFilterRequestDTO, CarFilter filter) {
        return repository
            .findAll(
                CarSpecification.of(filter),
                pageableFromDTO(carFilterRequestDTO.getPageRequest()))
            .map(mapper::toDTO);
    }

    @Override
    protected List<String> getAllowedSortProperties() {
        return SORT_FIELDS;
    }
    
}
