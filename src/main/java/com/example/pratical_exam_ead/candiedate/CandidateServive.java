package com.example.pratical_exam_ead.candiedate;

import com.example.pratical_exam_ead.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServive {
    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> findAll(){return candidateRepository.findAll();}

    public Optional<Candidate> findById(int id) {
        return candidateRepository.findById((id));
    }

    public Candidate save(Candidate student) {
        return candidateRepository.save(student);
    }

    public void deleteById(int id) {
        candidateRepository.deleteById((id));
    }
}
