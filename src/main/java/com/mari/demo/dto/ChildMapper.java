package com.mari.demo.dto;

import com.mari.demo.model.Child;

public class ChildMapper {

    public static ChildDTO fromEntityChildDTO(Child child) {
        return ChildDTO.builder()
                .id(child.getId())
                .name(child.getName())
                .fatherName(child.getFather() == null ? null : child.getFather().getName())
                .motherName(child.getMother() == null ? null : child.getMother().getName())
                .build();
    }
}
