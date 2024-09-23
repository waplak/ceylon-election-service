package io.ceylon.election.repository;

import io.ceylon.election.entity.ElectionResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ElectionResultRepository extends JpaRepository<ElectionResult,Long> {
    List<ElectionResult> findByElectionYear(Long year);
}
