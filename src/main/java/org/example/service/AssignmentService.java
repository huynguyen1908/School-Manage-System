package org.example.service;

import org.example.dto.request.AssignmentRequest;
import org.example.dto.respone.AssignmentDTO;

import java.util.List;

public interface AssignmentService {
    List<AssignmentDTO> getAllAssignments();
    AssignmentDTO createAssignment(AssignmentRequest request);
}
