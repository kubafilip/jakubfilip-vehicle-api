package com.jakub_filip.vehicle.services.impl.person;

import com.jakub_filip.vehicle.controllers.person.IPersonQueryService;
import com.jakub_filip.vehicle.dao.repositories.PersonRepository;
import com.jakub_filip.vehicle.dto.person.PersonDTO;
import com.jakub_filip.vehicle.dto.person.PersonFilterRequestDTO;
import com.jakub_filip.vehicle.dto.person.PersonFilterResponseDTO;
import com.jakub_filip.vehicle.exceptions.NotFoundObjectException;
import com.jakub_filip.vehicle.mappers.person.PersonMapper;
import com.jakub_filip.vehicle.services.searching.filter.person.PersonFilter;
import com.jakub_filip.vehicle.services.searching.finder.person.IPersonFinder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonQueryServiceImpl implements IPersonQueryService {
    
    private final PersonRepository repository;
    private final PersonMapper mapper;
    private final IPersonFinder finder;

    @Override
    public PersonDTO getPersonById(UUID personUuid) {
        return repository.findById(personUuid).map(mapper::toDTO).orElseThrow(NotFoundObjectException::new);
    }

    @Override
    public PersonFilterResponseDTO searchPersons(PersonFilterRequestDTO personFilterRequestDTO) {
        PersonFilter personFilter = mapper.toFilterFromFilterRequestDTO(personFilterRequestDTO);
        return finder.find(personFilterRequestDTO, personFilter);
    }
}
