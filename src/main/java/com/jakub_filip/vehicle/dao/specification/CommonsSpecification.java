package com.jakub_filip.vehicle.dao.specification;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class CommonsSpecification {

    public static <T> Specification<T> like(String entityField, String pattern) {
        return (root, query, criteriaBuilder) -> {
            if (StringUtils.isNotBlank(pattern)) {
                String likePattern = "%" + pattern.toLowerCase().trim().replace(" ", "%") + "%";
                return criteriaBuilder.like(criteriaBuilder.lower(root.get(entityField)), likePattern);
            }
            return null;
        };
    }
}
