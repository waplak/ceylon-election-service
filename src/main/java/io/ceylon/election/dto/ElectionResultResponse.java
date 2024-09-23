package io.ceylon.election.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElectionResultResponse {
    private Long candidateId;
    private String candidateName;
    private String districtName;
    private Long votes;
    private Long electionYear;
}
