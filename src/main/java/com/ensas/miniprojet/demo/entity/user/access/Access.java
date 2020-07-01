package com.ensas.miniprojet.demo.entity.user.access;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//@Entity
public class Access implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ElementCollection(targetClass = TypeAcces.class)
    @Enumerated(EnumType.STRING)
    private List<TypeAcces> typeAcces;
    public Access() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TypeAcces> getTypeAcces() {
        return typeAcces;
    }

    public void setTypeAcces(List<TypeAcces> typeAcces) {
        this.typeAcces = typeAcces;
    }
}
