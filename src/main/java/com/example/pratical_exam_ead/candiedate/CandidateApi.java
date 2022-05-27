package com.example.pratical_exam_ead.candiedate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

public class CandidateApi {
    @Autowired
    CandidateServive candidateServive;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Candidate>> getList() {
        return ResponseEntity.ok(candidateServive.findAll());
    }


    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getDetail(@PathVariable int id) {
        Optional<Candidate> optionalAccount = candidateServive.findById(id)
                ;
        if (!optionalAccount.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalAccount.get());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Candidate> create(@RequestBody Candidate candidate) {
        return ResponseEntity.ok(candidateServive.save(candidate));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Candidate> update(@PathVariable int id, @RequestBody Candidate candidate) {
        Optional<Candidate> optionalAccount = candidateServive.findById(id)
                ;
        if (!optionalAccount.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Candidate existstudent = optionalAccount.get();
        existstudent.setName(candidate.getName());
        existstudent.setAddress(candidate.getAddress());
        return ResponseEntity.ok(candidateServive.save(existstudent));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!candidateServive.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        candidateServive.deleteById(id)
        ;
        return ResponseEntity.ok().build();
    }
}

