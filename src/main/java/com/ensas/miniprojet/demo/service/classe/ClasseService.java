package com.ensas.miniprojet.demo.service.classe;

import com.ensas.miniprojet.demo.entity.Classe;
import com.ensas.miniprojet.demo.entity.Departement;

import java.util.List;

public interface ClasseService {

    List<Classe> getClasses();
    Classe getClasse(Long classeId);
    Classe addClassee(Classe classe);
    void delClasse(Long classeId);
    Classe updateClasse(Classe classe);
}
