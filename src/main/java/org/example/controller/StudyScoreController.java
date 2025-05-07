package org.example.controller;

import org.example.dto.request.StudyScoreRequest;
import org.example.dto.respone.StudyScoreDTO;
import org.example.service.StudyScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudyScoreController {

    @Autowired
    private StudyScoreService studyScoreService;

    @GetMapping("/students/{id}/scores")
    public List<StudyScoreDTO> getStudentScore(@PathVariable String id) {
        return studyScoreService.getScoresByStudentId(id);
    }

    @PostMapping("/scores")
    public StudyScoreDTO enterScore(@RequestBody StudyScoreRequest request) {
        return studyScoreService.enterScore(request);
    }
}
