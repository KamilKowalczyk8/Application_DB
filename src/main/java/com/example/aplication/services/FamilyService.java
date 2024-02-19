package com.example.aplication.services;


import com.example.aplication.model.FamilyDB;
import com.example.aplication.repository.FamilyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyService {
    public FamilyService(FamilyRepository familyRepository){
        this.familyRepository = familyRepository;
    }
    FamilyRepository familyRepository;

    public void save(FamilyDB familyDB){familyRepository.save(familyDB);}

    public List<FamilyDB> findByName(String name){
        return (List<FamilyDB>) familyRepository.findByName(name);
    }
}
