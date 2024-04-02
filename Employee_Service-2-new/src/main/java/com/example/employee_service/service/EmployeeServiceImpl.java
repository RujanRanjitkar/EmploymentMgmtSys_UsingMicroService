package com.example.employee_service.service;

import com.example.employee_service.dto.AddressResponseDto;
import com.example.employee_service.dto.EmployeeRequestDto;
import com.example.employee_service.dto.EmployeeResponseDto;
import com.example.employee_service.feignClient.AddressClient;
import com.example.employee_service.model.Employee;
import com.example.employee_service.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AddressClient addressClient; //spring will create the implementation for address client and will inject the bean here

    @Override
    public EmployeeResponseDto getEmployeeById(int employeeId) {

        Employee employee = employeeRepo.findById(employeeId).get(); //db call

        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();

        employeeResponseDto.setEmployeeName(employee.getEmployeeName());
        employeeResponseDto.setEmail(employee.getEmail());
        employeeResponseDto.setBloodGroup(employee.getBloodGroup());

        //addressResponseDto -> set data by making a rest api call
        AddressResponseDto addressResponseDto = addressClient.getAddressByEmployeeId(employeeId);

        employeeResponseDto.setAddressResponseDto(addressResponseDto);

        return employeeResponseDto;
    }

    @Override
    public void addNewEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = new Employee();

        employee.setEmployeeName(employeeRequestDto.getEmployeeName());
        employee.setEmail(employeeRequestDto.getEmail());
        employee.setBloodGroup(employeeRequestDto.getBloodGroup());

        employeeRepo.save(employee);
    }
}
