package com.example.aplication.mediator;

import com.example.aplication.model.*;
import com.example.aplication.services.FamilyService;
import com.example.aplication.services.MemberService;
import com.example.aplication.translator.TranslatorFamilyDBtoFamilyDTO;
import com.example.aplication.translator.TranslatorFamilyDTOtoFamilyDB;
import com.example.aplication.translator.TranslatorMemberDBToMemberDTO;
import com.example.aplication.translator.TranslatorMemberDTOtoMemberDB;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mediator {
    public Mediator(
            TranslatorFamilyDBtoFamilyDTO translatorFamilyDBtoFamilyDTO,
            TranslatorMemberDBToMemberDTO translatorMemberDBToMemberDTO,
            FamilyService familyService,
            TranslatorFamilyDTOtoFamilyDB translatorFamilyDTOtoFamilyDB,
            MemberService memberService,
            TranslatorMemberDTOtoMemberDB translatorMemberDTOtoMemberDB
        ){
        this.translatorFamilyDBtoFamilyDTO = translatorFamilyDBtoFamilyDTO;
        this.translatorMemberDBToMemberDTO = translatorMemberDBToMemberDTO;
        this.translatorFamilyDTOtoFamilyDB = translatorFamilyDTOtoFamilyDB;

        this.translatorMemberDTOtoMemberDB = translatorMemberDTOtoMemberDB;
        this.memberService = memberService;
        this.familyService = familyService;
    }
    TranslatorFamilyDTOtoFamilyDB translatorFamilyDTOtoFamilyDB;
    TranslatorFamilyDBtoFamilyDTO translatorFamilyDBtoFamilyDTO;
    TranslatorMemberDBToMemberDTO translatorMemberDBToMemberDTO;
    TranslatorMemberDTOtoMemberDB translatorMemberDTOtoMemberDB;
    FamilyService familyService;

    MemberService memberService;


    public void saveFamily(FamilyDTO familyDTO){
        FamilyDB familyDB = translatorFamilyDTOtoFamilyDB.toFamilyDB(familyDTO);
        familyService.save(familyDB);
    }

    public void updateFamily(FamilyExtendedDTO familyDTO){
        FamilyDB familyDB = translatorFamilyDTOtoFamilyDB.toFamilyDB(familyDTO);
        familyService.save(familyDB);
    }

    public void saveMembers(MembersDTO membersDTO){
        MembersDB membersDB = translatorMemberDTOtoMemberDB.toMember(membersDTO);
        memberService.save(membersDB);
    }

    public void updateMembers(MembersExtendedDTO membersExtendedDTO){
        MembersDB membersDB = translatorMemberDTOtoMemberDB.toMember(membersExtendedDTO);
        memberService.save(membersDB);
    }
    public List<MembersExtendedDTO> getAllMembers(){
        List<MembersDB> list = memberService.getAll();
        List<MembersExtendedDTO> extendedDTOList = new ArrayList<>();
        for(MembersDB membersDB:list){
            extendedDTOList.add(translatorMemberDBToMemberDTO.toMemberExtendedDTO(membersDB));
        }
        return extendedDTOList;
    }
}
