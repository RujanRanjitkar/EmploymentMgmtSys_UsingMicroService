package com.example.address_service.service;

import com.example.address_service.dto.AddressResponseDto;
import com.example.address_service.model.Address;
import com.example.address_service.repo.AddressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final AddressRepo addressRepo;
    @Override
    public AddressResponseDto getAddressByEmployeeId(int employeeId) {
        Address address=addressRepo.findAddressByEmployeeId(employeeId);

        System.out.println("Finding address by employeeId: " + employeeId);

        AddressResponseDto addressResponseDto=new AddressResponseDto();

        addressResponseDto.setLane1(address.getLane1());
        addressResponseDto.setLane2(address.getLane2());
        addressResponseDto.setState(address.getState());
        addressResponseDto.setZip(address.getZip());

        return addressResponseDto;
    }
}
