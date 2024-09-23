package io.ceylon.election.specification;

import io.ceylon.election.entity.ElectionResult;
import org.springframework.data.jpa.domain.Specification;

public class ElectionResultSpecification {

    public static Specification<ElectionResult> withYear(Long year) {
        return (root, query, criteriaBuilder) ->
                year != null ? criteriaBuilder.equal(root.get("electionYear"), year) : criteriaBuilder.conjunction();
    }
    public static Specification<ElectionResult> withDistrictId(Long districtId) {
        return (root, query, criteriaBuilder) ->
                districtId != null ? criteriaBuilder.equal(root.get("districtId"), districtId) : criteriaBuilder.conjunction();
    }

    public static Specification<ElectionResult> withCandidateId(Long candidateId) {
        return (root, query, criteriaBuilder) ->
                candidateId != null ? criteriaBuilder.equal(root.get("candidateId"), candidateId) : criteriaBuilder.conjunction();
    }
}
