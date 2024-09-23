package io.ceylon.election.controller;

import io.ceylon.election.dto.ElectionResultResponse;
import io.ceylon.election.service.ElectionResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
