package com.example.aplication.translator;

import com.example.aplication.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;

@Mapper
public abstract class TranslatorFamilyDBtoFamilyDTO {

    public FamilyExtendedDTO TofamilyExtendedDTO(FamilyDB familyDB){
        FamilyExtendedDTO familyExtendedDTO = TofamilyDTO(familyDB);
        return familyExtendedDTO;
    }
    public FamilyDTO toFamily(FamilyDB familyDB){
        FamilyDTO familyDTO = toFamilyDTO(familyDB);
        return familyDTO;
    }

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "origin", target = "origin"),
    })
    protected abstract FamilyDTO toFamilyDTO(FamilyDB familyDB);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "origin", target = "origin"),
            @Mapping(expression = "java(toMemberDTO(familyDB.getHead()))", target = "head"),
    })
    protected abstract FamilyExtendedDTO TofamilyDTO(FamilyDB familyDB);


    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "age", target = "age"),
            @Mapping(source = "gender", target = "gender"),
    })
    protected abstract MembersDTO toMemberDTO(MembersDB membersDB);

}
