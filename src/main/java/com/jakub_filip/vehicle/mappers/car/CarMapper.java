package com.jakub_filip.vehicle.mappers.car;


import com.jakub_filip.vehicle.dto.car.CarCreateRequestDTO;
import com.jakub_filip.vehicle.dto.car.CarDTO;
import com.jakub_filip.vehicle.dto.car.CarFilterRequestDTO;
import com.jakub_filip.vehicle.dto.car.CarUpdateRequestDTO;
import com.jakub_filip.vehicle.entities.car.CarEntity;
import com.jakub_filip.vehicle.services.searching.filter.car.CarFilter;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDTO toDTO(CarEntity entity);

    CarEntity toEntity(CarCreateRequestDTO createRequestDTO);

    CarEntity toEntity(CarUpdateRequestDTO updateRequestDTO);

    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget CarEntity actual, CarEntity requested);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFields(@MappingTarget CarEntity actual, CarEntity requested);

    CarFilter toFilterFromFilterRequestDTO(CarFilterRequestDTO carFilterRequestDTO);

}
