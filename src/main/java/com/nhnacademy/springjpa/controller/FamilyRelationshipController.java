package com.nhnacademy.springjpa.controller;


import com.nhnacademy.springjpa.repository.FamilyRelationshipRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/residents/{serialNumber}/relationship")
public class FamilyRelationshipController {
    private final FamilyRelationshipRepository familyRelationshipRepository;

    public FamilyRelationshipController(FamilyRelationshipRepository familyRelationshipRepository) {
        this.familyRelationshipRepository = familyRelationshipRepository;
    }
//
//    @PostMapping("/")
//    public FamilyRelationship createFamilyRelationship() {
//        familyRelationshipRepository.save()
//    }
}
