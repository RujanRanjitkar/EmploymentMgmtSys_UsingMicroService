package com.example.employee_service.openFeignClient;


import com.example.employee_service.dto.AddressResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ADDRESS-SERVICE", path = "/address-app/api")
public interface AddressClient { //proxy

    @GetMapping("/get_address_by_employee_id/{employeeId}")
    ResponseEntity<AddressResponseDto> getAddressByEmployeeId(@PathVariable("employeeId") int employeeId);
}
