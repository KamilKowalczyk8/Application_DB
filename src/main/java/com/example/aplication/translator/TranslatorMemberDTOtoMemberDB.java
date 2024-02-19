package com.example.aplication.translator;

import com.example.aplication.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public abstract class TranslatorMemberDTOtoMemberDB {

    public MembersDB toMember(MembersDTO membersDTO){
            return toMemberDB(membersDTO);
    }

    public MembersDB toMember(MembersExtendedDTO membersExtendedDTO){
            return toMemberDB(membersExtendedDTO);
    }
    @Mappings({
            @Mapping(target = "id",ignore = true),
            @Mapping(target = "name",source = "name"),
            @Mapping(target = "age",source = "age"),
            @Mapping(target = "gender",source = "gender"),
            @Mapping(target = "familyId",ignore = true)
    })
    protected abstract MembersDB toMemberDB(MembersDTO membersDTO);

    @Mappings({
            @Mapping(target = "id",ignore = true),
            @Mapping(target = "name",source = "name"),
            @Mapping(target = "age",source = "age"),
            @Mapping(target = "gender",source = "gender"),
            @Mapping(target = "familyId",expression = "java(toFamilyDB(membersExtendedDTO.getFamily()))")
    })
    protected abstract MembersDB toMemberDB(MembersExtendedDTO membersExtendedDTO);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "origin", target = "origin"),
    })
    protected abstract FamilyDB toFamilyDB(FamilyDTO familyDTO);
}
