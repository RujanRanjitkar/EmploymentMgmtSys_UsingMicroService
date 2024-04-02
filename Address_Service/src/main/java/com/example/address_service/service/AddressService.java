package com.example.address_service.service;

import com.example.address_service.dto.AddressResponseDto;

public interface AddressService {
    AddressResponseDto getAddressByEmployeeId(int employeeId);
}
