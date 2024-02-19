package com.example.aplication.repository;

import com.example.aplication.model.FamilyDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<FamilyDB, Long> {

Iterable<FamilyDB> findByName(String name);

}
