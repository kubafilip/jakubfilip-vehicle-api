package com.jakub_filip.vehicle.dto.pagination;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaginatedResultMetadataDTO {

    @JsonProperty("pageSize")
    private Integer pageSize;
    @JsonProperty("pageNumber")
    private Integer pageNumber;
    @JsonProperty("pagesCount")
    private Integer pagesCount;
    @JsonProperty("totalItemsCount")
    private Long totalItemsCount;
}
