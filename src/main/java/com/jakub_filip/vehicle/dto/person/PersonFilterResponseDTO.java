package com.jakub_filip.vehicle.dto.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jakub_filip.vehicle.dto.pagination.PaginatedResultMetadataDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class PersonFilterResponseDTO {

    @JsonProperty("people")
    @Valid
    private List<PersonDTO> people = null;
    @JsonProperty("metadata")
    private PaginatedResultMetadataDTO metadata;

    public PersonFilterResponseDTO() {
    }

    public PersonFilterResponseDTO people(List<PersonDTO> people) {
        this.people = people;
        return this;
    }

    public PersonFilterResponseDTO addPeopleItem(PersonDTO peopleItem) {
        if (this.people == null) {
            this.people = new ArrayList();
        }

        this.people.add(peopleItem);
        return this;
    }

    public PersonFilterResponseDTO metadata(PaginatedResultMetadataDTO metadata) {
        this.metadata = metadata;
        return this;
    }
}
