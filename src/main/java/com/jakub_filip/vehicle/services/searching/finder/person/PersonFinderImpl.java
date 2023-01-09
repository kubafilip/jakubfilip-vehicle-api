package com.jakub_filip.vehicle.services.searching.finder.person;


import com.jakub_filip.vehicle.dao.repositories.PersonRepository;
import com.jakub_filip.vehicle.dao.specification.PersonSpecification;
import com.jakub_filip.vehicle.dto.person.PersonDTO;
import com.jakub_filip.vehicle.dto.person.PersonFilterRequestDTO;
import com.jakub_filip.vehicle.dto.person.PersonFilterResponseDTO;
import com.jakub_filip.vehicle.entities.person.PersonEntity_;
import com.jakub_filip.vehicle.mappers.person.PersonMapper;
import com.jakub_filip.vehicle.services.searching.AbstractFinder;
import com.jakub_filip.vehicle.services.searching.filter.person.PersonFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonFinderImpl extends AbstractFinder implements IPersonFinder {

    private final PersonMapper mapper;
    private final PersonRepository repository;

    private static final List<String> SORT_FIELDS = List.of(PersonEntity_.NAME);

    @Override
    public PersonFilterResponseDTO find(PersonFilterRequestDTO personFilterRequestDTO, PersonFilter personFilter) {
        Page<PersonDTO> results = getSearchResult(personFilterRequestDTO, personFilter);
        return new PersonFilterResponseDTO()
            .people(results.getContent())
            .metadata(paginatedMetadataFromPage(results));
    }

    private Page<PersonDTO> getSearchResult(
        PersonFilterRequestDTO personFilterRequestDTO, PersonFilter filter) {
        return repository
            .findAll(
                PersonSpecification.of(filter),
                pageableFromDTO(personFilterRequestDTO.getPageRequest()))
            .map(mapper::toDTO);
    }

    @Override
    protected List<String> getAllowedSortProperties() {
        return SORT_FIELDS;
    }
}
