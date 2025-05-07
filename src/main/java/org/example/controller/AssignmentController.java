package org.example.controller;

import org.example.dto.request.AssignmentRequest;
import org.example.dto.respone.AssignmentDTO;
import org.example.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @GetMapping
    public List<AssignmentDTO> getAssignments() {
        return assignmentService.getAllAssignments();
    }

    @PostMapping
    public AssignmentDTO sendAssignment(@RequestBody AssignmentRequest request) {
        return assignmentService.createAssignment(request);
    }
}
