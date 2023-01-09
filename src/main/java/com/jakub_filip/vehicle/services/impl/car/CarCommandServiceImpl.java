package com.jakub_filip.vehicle.services.impl.car;

import com.jakub_filip.vehicle.controllers.car.ICarCommandService;
import com.jakub_filip.vehicle.dao.repositories.CarRepository;
import com.jakub_filip.vehicle.dao.repositories.PersonRepository;
import com.jakub_filip.vehicle.dto.car.CarCreateRequestDTO;
import com.jakub_filip.vehicle.dto.car.CarDTO;
import com.jakub_filip.vehicle.dto.car.CarUpdateRequestDTO;
import com.jakub_filip.vehicle.entities.car.CarEntity;
import com.jakub_filip.vehicle.entities.person.PersonEntity;
import com.jakub_filip.vehicle.exceptions.NotFoundObjectException;
import com.jakub_filip.vehicle.mappers.car.CarMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarCommandServiceImpl implements ICarCommandService {

    private final CarRepository repository;
    private final PersonRepository personRepository;
    private final CarMapper mapper;

    @Override
    public CarDTO createCar(CarCreateRequestDTO createCarRequestDTO) {
        CarEntity entity = mapper.toEntity(createCarRequestDTO);
        CarEntity persistedEntity = repository.save(entity);
        log.info("Created car with id: {}", persistedEntity.getId());
        return mapper.toDTO(persistedEntity);
    }

    @Override
    public CarDTO updateCarById(UUID carUuid, CarUpdateRequestDTO carUpdateRequestDTO) {
        CarEntity actualEntity = repository.findById(carUuid).orElseThrow(NotFoundObjectException::new);
        CarEntity requestedEntity = mapper.toEntity(carUpdateRequestDTO);
        mapper.updateEntity(actualEntity, requestedEntity);
        CarEntity persistedEntity = repository.save(actualEntity);
        log.info("Updated car with id: {}", persistedEntity.getId());
        return mapper.toDTO(persistedEntity);
    }

    @Override
    public void deleteCarById(UUID carUuid) {
        CarEntity entity = repository.findById(carUuid).orElseThrow(NotFoundObjectException::new);
        repository.delete(entity);
        log.info("Deleted car with id: {}", carUuid);
    }

    @Override
    public void assignCarToPersonById(UUID carUuid, UUID personUuid) {
        log.info("Searching car by id: {}", carUuid);
        CarEntity carEntity = repository.findById(carUuid).orElseThrow(NotFoundObjectException::new);
        log.info("Car found");
        log.info("Searching person by id: {}", personUuid);
        PersonEntity personEntity = personRepository.findById(personUuid).orElseThrow(NotFoundObjectException::new);
        log.info("Person found");
        carEntity.setPerson(personEntity);
        repository.save(carEntity);
        log.info("Car with id = {} assigned to person with id = {}", carUuid, personUuid);
    }

}
