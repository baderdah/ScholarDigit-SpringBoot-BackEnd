package com.ensas.miniprojet.demo.service.filiere;

import com.ensas.miniprojet.demo.entity.Filiere;

import java.util.List;

public interface FiliereService {
    List<Filiere> getFilieres();
    Filiere getFiliere(Long filiereId);
    Filiere addFiliere(Filiere filiere);
    void delFiliere(Long filiereId);
    Filiere updateFiliere(Filiere filiere);
}
