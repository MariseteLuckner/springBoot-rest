package com.mari.demo.dto;

import com.mari.demo.model.Parent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChildDTO {

    private Long id;

    private String name;

    private String fatherName;

    private String motherName;
}
