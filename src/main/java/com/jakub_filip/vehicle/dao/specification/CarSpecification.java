package com.jakub_filip.vehicle.dao.specification;

import com.jakub_filip.vehicle.entities.car.CarEntity;
import com.jakub_filip.vehicle.entities.car.CarEntity_;
import com.jakub_filip.vehicle.services.searching.filter.car.CarFilter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.isNull;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CarSpecification implements Specification<CarEntity> {

    private final CarFilter filter;

    public static CarSpecification of(CarFilter filter) {
        if (isNull(filter)) {
            throw new IllegalArgumentException("Filter can not be null!");
        }
        return new CarSpecification(filter);
    }

    @Override
    public Predicate toPredicate(Root<CarEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new LinkedList<>();
        if (!isNull(filter.getBrand())) {
            predicates.add(getPredicateForBrand(root, criteriaBuilder));
        }
        if (!isNull(filter.getModel())) {
            predicates.add(getPredicateForMemorySizeMin(root, criteriaBuilder));
        }

        return predicates.isEmpty() ? null : criteriaBuilder.and(predicates.toArray(Predicate[]::new));
    }

    private Predicate getPredicateForBrand(Root<CarEntity> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get(CarEntity_.BRAND), filter.getBrand());
    }

    private Predicate getPredicateForMemorySizeMin(Root<CarEntity> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get(CarEntity_.MODEL), filter.getModel());
    }

}
