package com.example.employee_service.feignClient;

import com.example.employee_service.dto.AddressResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//http://localhost:8081/address-app/api/get_address_by_employee_id/1
@FeignClient(name = "address-service", url = "http://localhost:8081", path = "/address-app/api/")
public interface AddressClient { //proxy class

    @GetMapping("/get_address_by_employee_id/{employeeId}")
    AddressResponseDto getAddressByEmployeeId(@PathVariable("employeeId") int employeeId);
}
