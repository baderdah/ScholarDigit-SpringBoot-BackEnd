package com.ensas.miniprojet.demo.entity;

import com.ensas.miniprojet.demo.entity.Classe;
import com.ensas.miniprojet.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@DynamicUpdate
public class Student extends User implements Serializable {

    private String cne;
    private String adresse;
    private String sexe;
    @Temporal(TemporalType.DATE)
    private Date dateN;
    private String tel;
    private String profilePicture;



    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    @ManyToOne
    private Classe classe;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Date getDateN() {
        return dateN;
    }

    public void setDateN(Date dateN) {
        this.dateN = dateN;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


//    @JsonIgnore
    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }


    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    @Override
    public String toString() {

        return "Student{" +
                "cne='" + cne + '\'' +
                ", classe=" + classe +
                '}' +  super.toString();
    }
}
