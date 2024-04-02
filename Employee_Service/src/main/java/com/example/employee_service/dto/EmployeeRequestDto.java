package com.example.employee_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDto {
    private String employeeName;
    private String email;
    private String bloodGroup;
}
