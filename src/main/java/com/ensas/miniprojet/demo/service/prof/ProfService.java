package com.ensas.miniprojet.demo.service.prof;

import com.ensas.miniprojet.demo.dto.AbsenceData;
import com.ensas.miniprojet.demo.entity.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProfService {
    List<Prof> getProfs();
    Prof getProf(Long profId);
    Prof addProf(Prof prof);
    void delProf(Long profId);
    Prof updateProf(Prof prof);
    List<Classe> getClassess(String userName);
    List<Module> getModules(String userName);

    List<Student> getStudentOfClasse(@RequestBody Long classeID);

    void markAbsence(AbsenceData absenceData);
    List<Absence> getStudentAbsences(Long studentId);
    List<Absence> getModuleAbsences(Long moduleId);
}
