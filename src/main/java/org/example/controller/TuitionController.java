package org.example.controller;

import org.example.dto.request.TuitionRequest;
import org.example.dto.respone.TuitionDTO;
import org.example.entity.Tuition;
import org.example.service.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tuition")
public class TuitionController {

    private final TuitionService tuitionService;

    @Autowired
    public TuitionController(TuitionService tuitionService) {
        this.tuitionService = tuitionService;
    }

    @PostMapping
    public ResponseEntity<Tuition> createStudentTuition(@RequestBody TuitionRequest tuitionRequest) {
        Tuition tuition = tuitionService.createStudentTuition(tuitionRequest);
        return ResponseEntity.ok(tuition);
    };
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<TuitionDTO>> getStudentTuitionsByStudentId(@PathVariable("studentId") String studentId) {
        // Gọi service để lấy danh sách học phí của học sinh
        List<TuitionDTO> tuitionDTOs = tuitionService.getStudentTuitionsByStudentId(studentId);

        // Trả về danh sách học phí
        return ResponseEntity.ok(tuitionDTOs);
    }
    @GetMapping("/{tuitionId}")
    public ResponseEntity<TuitionDTO> getTuitionById(@PathVariable("tuitionId") String tuitionId) {
        TuitionDTO dto = tuitionService.getTuitionById(tuitionId);
        return ResponseEntity.ok(dto);
    }
}

