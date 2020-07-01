package com.ensas.miniprojet.demo.dto.scholarityDto;

import com.ensas.miniprojet.demo.dto.UserDto;
import com.ensas.miniprojet.demo.entity.Classe;
import com.ensas.miniprojet.demo.entity.User;

public class Student extends UserDto {
    private String cne;
    private Classe classe;

    public Student(User user) {
        super(user);
    }

    public String getCne() {
        return cne;
    }
    public void setCne(String cne) {
        this.cne = cne;
    }
}
