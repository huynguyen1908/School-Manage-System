package org.example.service;

import org.example.dto.request.TuitionRequest;
import org.example.dto.respone.TuitionDTO;
import org.example.entity.Tuition;

import java.util.List;

public interface TuitionService {
    Tuition createStudentTuition(TuitionRequest tuitionRequest);
    List<TuitionDTO> getStudentTuitionsByStudentId(String studentId);
    // TuitionService.java
    TuitionDTO getTuitionById(String tuitionId);



}
