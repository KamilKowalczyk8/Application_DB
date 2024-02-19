package com.example.aplication.fasada;

import com.example.aplication.mediator.Mediator;
import com.example.aplication.model.*;
import com.example.aplication.translator.TranslatorMemberDBToMemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FamilyController {

    public FamilyController(Mediator mediator){
        this.mediator = mediator;
    }
    Mediator mediator;
    @RequestMapping(method = RequestMethod.POST,value = "/save")
    public void saveFamily(@RequestBody FamilyDTO familyDTO){
        mediator.saveFamily(familyDTO);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/getbyname")
    public List<FamilyExtendedDTO> getFamilyByParam(@RequestParam String name){
        return mediator.getByName(name);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/getAll")
    public  List<FamilyExtendedDTO> getAllFamily(){
        return mediator.getAll();
    }


    //@Autowired
   // TranslatorMemberDBToMemberDTO translatorFamilyDBtoFamilyDTO;

  //  @GetMapping("/test")
  //  public MembersExtendedDTO saveFamily(){
   //     FamilyDB familyDB = new FamilyDB(1,"Nowak","Polskie",null);
   //     MembersDB membersDB = new MembersDB(1,"Tomek",12, Gender.MEN,familyDB);
    //    return  translatorFamilyDBtoFamilyDTO.toMemberExtendedDTO(membersDB);

//        familyDB.setHead(membersDB);
//
//        return translatorFamilyDBtoFamilyDTO.TofamilyExtendedDTO(familyDB);
   // }



}
