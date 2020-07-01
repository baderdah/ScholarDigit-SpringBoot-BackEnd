package com.ensas.miniprojet.demo.service.departement;

import com.ensas.miniprojet.demo.entity.Departement;

import java.util.List;

public interface DepartementService {
    List<Departement> getDepartements();
    Departement getDepartement(Long departementId);
    Departement addDepartemente(Departement departement);
    void delDepartement(Long departementId);
    Departement updateDepartement(Departement departement);
}
