package org.example.mapper;

import org.example.dto.request.TuitionRequest;
import org.example.dto.respone.TuitionDTO;
import org.example.entity.Parent;
import org.example.entity.Tuition;
import org.example.entity.Student;
import org.example.enums.TuitionStatus;
import org.example.repository.ParentRepository;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TuitionMapper {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Tuition toEntity(TuitionRequest tuitionRequest) {
        Tuition tuition = new Tuition();

        // Tạo sinh viên từ studentId
        Student student = studentRepository.findById(tuitionRequest.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // Lấy phụ huynh từ sinh viên (Giả sử có mối quan hệ giữa sinh viên và phụ huynh)
        Parent parent = parentRepository.findByStudentId(student.getStudentId())
                .orElseThrow(() -> new RuntimeException("Parent not found"));

        // Cài đặt thông tin cho tuition
        tuition.setStudent(student);
        tuition.setDepartmentId(tuitionRequest.getDepartmentId());
        tuition.setAmount(tuitionRequest.getAmount());
        tuition.setDueDate(tuitionRequest.getDueDate());
        if (tuitionRequest.getStatus() != null) {
            tuition.setStatus(tuitionRequest.getStatus());
        } else {
            tuition.setStatus(TuitionStatus.UNPAID);
        }
        tuition.setParent(parent);  // Liên kết phụ huynh với thông báo học phí

        return tuition;
    }
    public static TuitionDTO toTuitionDTO(Tuition tuition) {
        TuitionDTO tuitionDTO = new TuitionDTO();
        tuitionDTO.setTuitionId(tuition.getTuitionId());
        tuitionDTO.setStudentId(tuition.getStudent().getStudentId());
        tuitionDTO.setDepartmentId(tuition.getDepartmentId());
        tuitionDTO.setAmount(tuition.getAmount());
        tuitionDTO.setDueDate(tuition.getDueDate());
        tuitionDTO.setPaidAt(tuition.getPaidAt());
        tuitionDTO.setStatus(tuition.getStatus());
        return tuitionDTO;
    }
}
