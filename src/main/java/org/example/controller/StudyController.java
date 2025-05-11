package org.example.controller;

import org.example.dto.request.StudyScoreRequest;
import org.example.dto.respone.StudyScoreDTO;
import org.example.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudyController {

    @Autowired
    private StudyService studyScoreService;

    @GetMapping("/students/{id}/scores")
    public List<StudyScoreDTO> getStudentScore(@PathVariable String id) {
        return studyScoreService.getScoresByStudentId(id);
    }

    @PostMapping("/scores")
    public StudyScoreDTO enterScore(@RequestBody StudyScoreRequest request) {
        return studyScoreService.enterScore(request);
    }
}
