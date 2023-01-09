package com.jakub_filip.vehicle.dao.specification;

import com.jakub_filip.vehicle.entities.person.PersonEntity;
import com.jakub_filip.vehicle.entities.person.PersonEntity_;
import com.jakub_filip.vehicle.services.searching.filter.person.PersonFilter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.isNull;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonSpecification implements Specification<PersonEntity> {

    private final PersonFilter filter;

    public static PersonSpecification of(PersonFilter filter) {
        if (isNull(filter)) {
            throw new IllegalArgumentException("Filter can not be null!");
        }
        return new PersonSpecification(filter);
    }
    
    @Override
    public Predicate toPredicate(Root<PersonEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (!isNull(filter.getMinAge())) {
          predicates.add(getPredicateForMinAge(root, criteriaBuilder));
        }
        if (!isNull(filter.getMaxAge())) {
            predicates.add(getPredicateForMaxAge(root, criteriaBuilder));
        }
        if (StringUtils.isNotBlank(filter.getSearchString())) {
            predicates.add(getPredicateForSearchString(root, query, criteriaBuilder));
        }
        return predicates.isEmpty() ? null : criteriaBuilder.and(predicates.toArray(Predicate[]::new));
    }

    private Predicate getPredicateForMinAge(Root<PersonEntity> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.greaterThanOrEqualTo(root.get(PersonEntity_.AGE), filter.getMinAge());
    }

    private Predicate getPredicateForMaxAge(Root<PersonEntity> root, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.lessThanOrEqualTo(root.get(PersonEntity_.AGE), filter.getMaxAge());
    }

    private Predicate getPredicateForSearchString(Root<PersonEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<String> searchPhrases = splitSearchString(filter.getSearchString());

        Specification<PersonEntity> nameSearch = CommonsSpecification.like(PersonEntity_.NAME, searchPhrases.get(0));
        for (int i = 1; i < searchPhrases.size(); i++) {
            nameSearch.and(CommonsSpecification.like(PersonEntity_.NAME, searchPhrases.get(i)));
        }
        Specification<PersonEntity> surnameSearch = CommonsSpecification.like(PersonEntity_.SURNAME, searchPhrases.get(0));
        for (int i = 1; i < searchPhrases.size(); i++) {
            surnameSearch.and(CommonsSpecification.like(PersonEntity_.SURNAME, searchPhrases.get(i)));
        }
        Specification<PersonEntity> emailSearch = CommonsSpecification.like(PersonEntity_.EMAIL, searchPhrases.get(0));
        for (int i = 1; i < searchPhrases.size(); i++) {
            emailSearch.and(CommonsSpecification.like(PersonEntity_.EMAIL, searchPhrases.get(i)));
        }
        Specification<PersonEntity> specification = nameSearch.or(surnameSearch).or(emailSearch);
        return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
    }

    private List<String> splitSearchString(String searchText) {
        return Stream.of(searchText.trim().split("\\s+"))
            .map(String::toLowerCase)
            .collect(Collectors.toList());
    }

}
