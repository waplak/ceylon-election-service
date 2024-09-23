package io.ceylon.election.service.impl;

import io.ceylon.election.exception.DataNotFoundException;
import io.ceylon.election.dto.ElectionResultResponse;
import io.ceylon.election.entity.ElectionResult;
import io.ceylon.election.repository.ElectionResultRepository;
import io.ceylon.election.service.ElectionResultService;
import io.ceylon.election.specification.ElectionResultSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElectionResultServiceImpl implements ElectionResultService {

    @Autowired
    private ElectionResultRepository electionResultRepository;
    @Override
    public ResponseEntity<List<ElectionResultResponse>> getResultByYear(Long year) {
        List<ElectionResult> resultList = electionResultRepository.findByElectionYear(year);
        if(resultList.isEmpty()){
            throw new DataNotFoundException("No election result data available for the year 2024.","ELECTION_RESULTS_NOT_FOUND");
        }
        List<ElectionResultResponse> resultResponseList = convertElectionResult(resultList);
        return ResponseEntity.ok(resultResponseList);
    }

    @Override
    public ResponseEntity<List<ElectionResultResponse>> searchResultByYear(Long year, Long districtId, Long candidateId) {
        Specification<ElectionResult> spec = Specification.where(ElectionResultSpecification.withYear(year))
                .and(ElectionResultSpecification.withDistrictId(districtId))
                .and(ElectionResultSpecification.withCandidateId(candidateId));
        List<ElectionResult> resultList = electionResultRepository.findAll(spec);
        List<ElectionResultResponse> resultResponseList = convertElectionResult(resultList);
        return ResponseEntity.ok(resultResponseList);
    }

    private List<ElectionResultResponse> convertElectionResult(List<ElectionResult> resultList){
        return resultList.stream()
                .map(rs -> {
                    ElectionResultResponse result = new ElectionResultResponse();
                    result.setCandidateId(rs.getCandidateId());
                    result.setCandidateName(rs.getCandidate().getName());
                    result.setDistrictName(rs.getElectoralDistrict().getDistrictName());
                    result.setVotes(rs.getVotes());
                    return result;
                })
                .collect(Collectors.toList());
    }
}
