package io.ceylon.election.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "election_results")
@Data
public class ElectionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "result_id", nullable = false)
    private Long resultId;

    @Column(name = "candidate_id", nullable = false)
    private Long candidateId;

    @Column(name = "district_id", nullable = false)
    private Long districtId;

    @Column(name = "votes", nullable = false)
    private Long votes;

    @Column(name = "total_votes", nullable = false)
    private Long totalVotes;

    @Column(name = "election_year", nullable = false)
    private Long electionYear;

    @ManyToOne
    @JoinColumn(name = "candidate_id", insertable = false, updatable = false)
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "district_id", insertable = false, updatable = false)
    private ElectoralDistrict electoralDistrict;
}
