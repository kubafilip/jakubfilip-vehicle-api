package com.jakub_filip.vehicle.services.searching;

import java.util.List;
import java.util.stream.Collectors;


import com.jakub_filip.vehicle.dto.pagination.PageableMetadataDTO;
import com.jakub_filip.vehicle.dto.pagination.PaginatedResultMetadataDTO;
import com.jakub_filip.vehicle.dto.pagination.SortMetadataDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

public abstract class AbstractFinder {

    protected Pageable pageableFromDTO(PageableMetadataDTO pageableMetadataDTO) {
        int defaultPageSize = 10;
        if (pageableMetadataDTO == null) {
            return PageRequest.of(0, defaultPageSize, Direction.ASC, getAllowedSortProperties().get(0));
        } else {
            return PageRequest.of(
                pageableMetadataDTO.getPage(),
                pageableMetadataDTO.getSize() > 0 ? pageableMetadataDTO.getSize() : defaultPageSize,
                Sort.by(
                    pageableMetadataDTO.getSort().stream()
                        .map(
                            s -> {
                                String property =
                                    getAllowedSortProperties().contains(s.getProperty())
                                        ? s.getProperty()
                                        : getAllowedSortProperties().get(0);
                                if (SortMetadataDTO.DirectionEnum.DESC.equals(s.getDirection())) {
                                    return Order.desc(property);
                                } else {
                                    return Order.asc(property);
                                }
                            })
                        .collect(Collectors.toList())));
        }
    }

    protected PaginatedResultMetadataDTO paginatedMetadataFromPage(Page<?> page) {
        PaginatedResultMetadataDTO paginatedResultMetadataDTO = new PaginatedResultMetadataDTO();
        paginatedResultMetadataDTO.setPageNumber(page.getNumber());
        paginatedResultMetadataDTO.setPageSize(page.getSize());
        paginatedResultMetadataDTO.setPagesCount(page.getTotalPages());
        paginatedResultMetadataDTO.setTotalItemsCount(page.getTotalElements());

        return paginatedResultMetadataDTO;
    }

    protected abstract List<String> getAllowedSortProperties();
}
