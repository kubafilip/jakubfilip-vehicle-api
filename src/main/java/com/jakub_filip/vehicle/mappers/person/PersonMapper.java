package com.jakub_filip.vehicle.mappers.person;

import com.jakub_filip.vehicle.annotations.ToDTO;
import com.jakub_filip.vehicle.dto.person.PersonCreateRequestDTO;
import com.jakub_filip.vehicle.dto.person.PersonDTO;
import com.jakub_filip.vehicle.dto.person.PersonFilterRequestDTO;
import com.jakub_filip.vehicle.dto.person.PersonUpdateRequestDTO;
import com.jakub_filip.vehicle.entities.person.PersonEntity;
import com.jakub_filip.vehicle.services.searching.filter.person.PersonFilter;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @ToDTO
    PersonDTO toDTO(PersonEntity entity);

    PersonEntity toEntity(PersonCreateRequestDTO createRequestDTO);

    PersonEntity toEntity(PersonUpdateRequestDTO updateRequestDTO);

    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget PersonEntity actual, PersonEntity requested);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFields(@MappingTarget PersonEntity actual, PersonEntity requested);

    PersonFilter toFilterFromFilterRequestDTO(PersonFilterRequestDTO personFilterRequestDTO);
}
