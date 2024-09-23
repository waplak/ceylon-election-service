package io.ceylon.election.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="candidates")
@Data
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "candidate_id", nullable = false)
    private Long candidateId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "party_name", nullable = false)
    private String partyName;

    @Column(name = "party_symbol")
    private String partySymbol;

    @Column(name = "profile_image")
    private String profileImage;
}
