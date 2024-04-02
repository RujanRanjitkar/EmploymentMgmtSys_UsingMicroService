package com.example.employee_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponseDto {
    private String lane1;
    private String lane2;
    private String state;
    private int zip;
}
