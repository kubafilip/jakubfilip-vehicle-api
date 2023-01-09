package com.jakub_filip.vehicle.services.impl.person;

import com.jakub_filip.vehicle.controllers.person.IPersonCommandService;
import com.jakub_filip.vehicle.dao.repositories.CarRepository;
import com.jakub_filip.vehicle.dao.repositories.PersonRepository;
import com.jakub_filip.vehicle.dto.person.PersonCreateRequestDTO;
import com.jakub_filip.vehicle.dto.person.PersonDTO;
import com.jakub_filip.vehicle.dto.person.PersonUpdateRequestDTO;
import com.jakub_filip.vehicle.entities.car.CarEntity;
import com.jakub_filip.vehicle.entities.person.PersonEntity;
import com.jakub_filip.vehicle.exceptions.NotFoundObjectException;
import com.jakub_filip.vehicle.mappers.person.PersonMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonCommandServiceImpl implements IPersonCommandService {

    private final PersonRepository repository;
    private final PersonMapper mapper;
    private final CarRepository carRepository;

    @Override
    public PersonDTO createPerson(PersonCreateRequestDTO createPersonRequestDTO) {
        PersonEntity entity = mapper.toEntity(createPersonRequestDTO);
        PersonEntity persistedEntity = repository.save(entity);
        log.info("Created person with id: {}", persistedEntity.getId());
        return mapper.toDTO(persistedEntity);
    }

    @Override
    public PersonDTO updatePersonById(UUID personUuid, PersonUpdateRequestDTO personUpdateRequestDTO) {
        PersonEntity actualEntity = repository.findById(personUuid).orElseThrow(NotFoundObjectException::new);
        PersonEntity requestedEntity = mapper.toEntity(personUpdateRequestDTO);
        mapper.updateEntity(actualEntity, requestedEntity);
        PersonEntity persistedEntity = repository.save(actualEntity);
        log.info("Updated person with id: {}", persistedEntity.getId());
        return mapper.toDTO(persistedEntity);
    }

    @Override
    public void deletePersonById(UUID personUuid) {
        PersonEntity entity = repository.findById(personUuid).orElseThrow(NotFoundObjectException::new);
        for (CarEntity carEntity: entity.getCars()) {
            carEntity.setPerson(null);
            carRepository.save(carEntity);
        }
        repository.deleteById(personUuid);
        log.info("Deleted person with id: {}", personUuid);
    }

}
