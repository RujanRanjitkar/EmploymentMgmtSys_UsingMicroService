package com.example.address_service.controller;

import com.example.address_service.dto.AddressResponseDto;
import com.example.address_service.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/get_address_by_employee_id/{employeeId}")
    ResponseEntity<AddressResponseDto> getAddressByEmployeeId(@PathVariable("employeeId") int employeeId){
        AddressResponseDto addressResponseDto=addressService.getAddressByEmployeeId(employeeId);
        return ResponseEntity.ok(addressResponseDto);
    }
}
