package io.ceylon.election.controller;

import io.ceylon.election.dto.ElectionResultResponse;
import io.ceylon.election.service.ElectionResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ElectionResultController {

    @Autowired
    private ElectionResultService electionResultService;

    @GetMapping("/{year}")
    public ResponseEntity<List<ElectionResultResponse>> getResultByYear(@PathVariable("year") Long year){
        return  electionResultService.getResultByYear(year);
    }

    @GetMapping("/{year}/search")
    public ResponseEntity<List<ElectionResultResponse>> searchResultByYear(@PathVariable("year") Long year,
                                                                           @RequestParam(name ="districtId",required = false) Long districtId,
                                                                           @RequestParam(name ="candidateId",required = false) Long candidateId){
        return  electionResultService.searchResultByYear(year,districtId,candidateId);
    }
}
