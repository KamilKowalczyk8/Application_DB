package com.example.aplication.services;

import com.example.aplication.model.MembersDB;
import com.example.aplication.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    MemberRepository memberRepository;

    public void save(MembersDB membersDB){
        memberRepository.save(membersDB);

    }

    public List<MembersDB> getMembersDBbyName(String name){
        return (List<MembersDB>) memberRepository.findByName(name);

    }
}
