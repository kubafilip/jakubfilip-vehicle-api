package com.jakub_filip.vehicle.dto.pagination;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class PageableMetadataDTO {

    @JsonProperty("page")
    private Integer page = 0;
    @JsonProperty("size")
    private Integer size = 10;
    @JsonProperty("sort")
    @Valid
    private List<SortMetadataDTO> sort = null;
}
