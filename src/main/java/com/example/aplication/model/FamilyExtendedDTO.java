package com.example.aplication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FamilyExtendedDTO extends FamilyDTO{

    private MembersDTO head;
}
