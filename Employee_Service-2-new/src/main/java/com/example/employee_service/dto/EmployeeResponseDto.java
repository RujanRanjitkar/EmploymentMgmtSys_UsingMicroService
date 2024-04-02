package com.example.employee_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponseDto {
    private String employeeName;
    private String email;
    private String bloodGroup;
    private AddressResponseDto addressResponseDto;
}
