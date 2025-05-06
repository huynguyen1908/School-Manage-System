package org.example.mapper;

import org.example.dto.respone.ParentDTO;
import org.example.entity.Parent;

public class ParentMapper {
    public static ParentDTO toDTO(Parent parent) {
        return new ParentDTO(
                parent.getParentId(),
                parent.getName(),
                parent.getAge(),
                parent.getOccupation(),
                parent.getPhoneNumber(),
                parent.getDateOfBirth()
        );
    }
}
