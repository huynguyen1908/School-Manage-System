package org.example.mapper;

import org.example.dto.respone.DepartmentDTO;
import org.example.entity.Department;

public class DepartmentMapper {
    public static DepartmentDTO toDTO(Department department) {
        return new DepartmentDTO(
                department.getDepartmentId(),
                department.getDepartmentName(),
                department.getPhoneNumber()
        );
    }
}
