package com.ensas.miniprojet.demo.entity;

import com.ensas.miniprojet.demo.entity.Departement;
import com.ensas.miniprojet.demo.entity.Module;
import com.ensas.miniprojet.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Prof  extends User implements Serializable {

    private String matricule;

    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Departement departement;

    @OneToMany(mappedBy = "prof", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Module> modules;

    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
    @JsonIgnore
    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "Prof{" +
                "matricule='" + matricule + '\'' +
                ", departement=" + departement +
                ", modules=" + modules +
                "} " + super.toString();
    }
}
