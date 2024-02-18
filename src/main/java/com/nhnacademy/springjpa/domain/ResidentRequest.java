package com.nhnacademy.springjpa.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResidentRequest {
    private Integer residentSerialNumber;
    private String name;
    private String residentRegistrationNumber;
    private String genderCode;
    private LocalDateTime birthDate;
    private String birthPlaceCode;
    private String registrationBaseAddress;
    private LocalDateTime deathDate;
    private String deathPlaceCode;
    private String deathPlaceAddress;
}
