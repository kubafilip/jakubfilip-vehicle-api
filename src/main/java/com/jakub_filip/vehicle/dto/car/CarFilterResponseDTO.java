package com.jakub_filip.vehicle.dto.car;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jakub_filip.vehicle.dto.pagination.PaginatedResultMetadataDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CarFilterResponseDTO {

    @JsonProperty("cars")
    @Valid
    private List<CarDTO> cars = null;
    @JsonProperty("metadata")
    private PaginatedResultMetadataDTO metadata;

    public CarFilterResponseDTO() {
    }

    public CarFilterResponseDTO cars(List<CarDTO> cars) {
        this.cars = cars;
        return this;
    }

    public CarFilterResponseDTO addCarsItem(CarDTO carsItem) {
        if (this.cars == null) {
            this.cars = new ArrayList();
        }

        this.cars.add(carsItem);
        return this;
    }

    public CarFilterResponseDTO metadata(PaginatedResultMetadataDTO metadata) {
        this.metadata = metadata;
        return this;
    }
}
