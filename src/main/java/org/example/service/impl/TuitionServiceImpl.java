package org.example.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.dto.request.TuitionRequest;
import org.example.dto.respone.TuitionDTO;
import org.example.entity.Tuition;
import org.example.mapper.TuitionMapper;
import org.example.repository.TuitionRepository;
import org.example.service.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TuitionServiceImpl implements TuitionService {

    private final TuitionRepository tuitionRepository;
    private final TuitionMapper tuitionMapper;
    @Autowired
    public TuitionServiceImpl(TuitionRepository tuitionRepository, TuitionMapper tuitionMapper) {
        this.tuitionRepository = tuitionRepository;
        this.tuitionMapper = tuitionMapper;
    }


    @Override
    public Tuition createStudentTuition(TuitionRequest tuitionRequest) {
        Tuition tuition = tuitionMapper.toEntity(tuitionRequest);
        return tuitionRepository.save(tuition);
    }
    @Override
    public List<TuitionDTO> getStudentTuitionsByStudentId(String studentId) {
        // Tìm tất cả các học phí của học sinh theo studentId
        List<Tuition> tuitions = tuitionRepository.findByStudent_StudentId(studentId);

        // Chuyển từ List<Tuition> sang List<TuitionDTO>
        return tuitions.stream()
                .map(TuitionMapper::toTuitionDTO)  // Chuyển đổi từ entity sang DTO
                .collect(Collectors.toList());
    }
    @Override
    public TuitionDTO getTuitionById(String tuitionId) {
        Tuition tuition = tuitionRepository.findByTuitionId(tuitionId)
                .orElseThrow(() -> new RuntimeException("Tuition not found with id: " + tuitionId));
        return TuitionMapper.toTuitionDTO(tuition);
    }


}
