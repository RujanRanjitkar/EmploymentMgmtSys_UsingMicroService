package com.example.employee_service.service;

import com.example.employee_service.dto.EmployeeRequestDto;
import com.example.employee_service.dto.EmployeeResponseDto;
import com.example.employee_service.model.Employee;

public interface EmployeeService {
    EmployeeResponseDto getEmployeeById(int employeeId);

    void addNewEmployee(EmployeeRequestDto employeeRequestDto);
}
