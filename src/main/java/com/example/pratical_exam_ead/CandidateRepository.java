package com.example.pratical_exam_ead;

import com.example.pratical_exam_ead.candiedate.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,Integer> {
}
