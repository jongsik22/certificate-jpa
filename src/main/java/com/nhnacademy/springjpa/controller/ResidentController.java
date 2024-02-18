package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.ResidentRequest;
import com.nhnacademy.springjpa.entity.Resident;
import com.nhnacademy.springjpa.repository.ResidentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/residents")
public class ResidentController {
    private final ResidentRepository residentRepository;

    public ResidentController(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @PostMapping("/")
    public Resident createResident(@RequestBody ResidentRequest request) {
        Resident resident = new Resident();

        return residentRepository.save(requestToResident(resident, request));
    }

    @PutMapping("/{serialNumber}")
    public Resident modifyResident(@RequestBody ResidentRequest request, @PathVariable("serialNumber") Integer serialNumber) {
        Resident resident = null;
        if (residentRepository.findById(serialNumber).isPresent()) {
            resident = residentRepository.findById(serialNumber).get();
        }

        return residentRepository.save(requestToResident(resident, request));
    }

    private Resident requestToResident(Resident resident, ResidentRequest request) {
        resident.setName(request.getName());
        resident.setResidentRegistrationNumber(request.getResidentRegistrationNumber());
        resident.setGenderCode(request.getGenderCode());
        resident.setBirthDate(request.getBirthDate());
        resident.setBirthPlaceCode(request.getBirthPlaceCode());
        resident.setRegistrationBaseAddress(request.getRegistrationBaseAddress());
        resident.setDeathDate(request.getDeathDate());
        resident.setDeathPlaceCode(request.getDeathPlaceCode());
        resident.setDeathPlaceAddress(request.getDeathPlaceAddress());

        return resident;
    }
}
