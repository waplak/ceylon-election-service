package io.ceylon.election.service;

import io.ceylon.election.dto.ElectionResultResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ElectionResultService {
    ResponseEntity<List<ElectionResultResponse>> getResultByYear(Long year);

    ResponseEntity<List<ElectionResultResponse>> searchResultByYear(Long year, Long districtId, Long candidateId);
}
