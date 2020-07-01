package com.ensas.miniprojet.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "departement", cascade = {CascadeType.REMOVE})
    List<Filiere> filieres;

    @OneToMany(mappedBy = "departement")
    @OnDelete(action = OnDeleteAction.CASCADE)
    List<Prof> profs;


    @JsonIgnore
    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }
    @JsonIgnore
    public List<Prof> getProfs() {
        return profs;
    }

    public void setProfs(List<Prof> profs) {
        this.profs = profs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}

