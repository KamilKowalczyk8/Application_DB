package com.example.aplication.fasada;

import com.example.aplication.mediator.Mediator;
import com.example.aplication.model.FamilyDTO;
import com.example.aplication.model.MembersDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {
    public MemberController(Mediator mediator){
        this.mediator = mediator;
    }
    Mediator mediator;
    @RequestMapping(method = RequestMethod.POST,value = "/saveMember")
    public void save(@RequestBody MembersDTO membersDTO, @RequestParam long id){
        mediator.saveMembers(membersDTO,id);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/getAllMembers")
    public void getAll(){
        mediator.getAllMembers();
    }
}
