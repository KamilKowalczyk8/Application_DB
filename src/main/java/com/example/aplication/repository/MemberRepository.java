package com.example.aplication.repository;

import com.example.aplication.model.MembersDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MembersDB,Long> {

    Iterable<MembersDB> findByName(String name);
}
