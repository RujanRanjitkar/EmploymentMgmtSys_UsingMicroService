package com.example.employee_service.controller;

import com.example.employee_service.dto.EmployeeRequestDto;
import com.example.employee_service.dto.EmployeeResponseDto;
import com.example.employee_service.model.Employee;
import com.example.employee_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/get_employee_by_id/{employeeId}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable("employeeId") int employeeId) {
        EmployeeResponseDto employeeResponseDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeResponseDto);
    }

    @PostMapping("/add_new_employee")
    public ResponseEntity<String> addNewEmployee(@RequestBody EmployeeRequestDto employeeRequestDto){
        employeeService.addNewEmployee(employeeRequestDto);
        return ResponseEntity.ok("Employee added successfully");
    }
}
