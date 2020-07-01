package com.ensas.miniprojet.demo.service.scholarityService.impl;

import com.ensas.miniprojet.demo.entity.*;
import com.ensas.miniprojet.demo.model.AbsenceModel;
import com.ensas.miniprojet.demo.repository.absenceRepository.AbsenceRepository;
import com.ensas.miniprojet.demo.repository.entityRepository.CertifRepository;
import com.ensas.miniprojet.demo.repository.entityRepository.ClasseRepository;
import com.ensas.miniprojet.demo.repository.userRepository.StudentRepository;
import com.ensas.miniprojet.demo.service.scholarityService.ScholarityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class ScholarityServiceImpl implements ScholarityService {

    @Autowired
    ClasseRepository classeRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CertifRepository certifRepository;

    @Autowired
    AbsenceRepository absenceRepository;


    @Override
    @Transactional
    public List<Student> getStudentOfClasse(Long classeID) {
        List<Student> students = studentRepository.findByClasse_Id(classeID);
        return students;
    }

    @Override
    @Transactional
    public List<CertifRequest> getAllCertifRequest(){
        List<CertifRequest> certifRequests = certifRepository.findAll();
        return  certifRequests;
    }

    @Override
    @Transactional
    public List<AbsenceModel> getClasseAbsences(Long classeId) {

        List<AbsenceModel> absencesModel = new ArrayList<>();
        Classe classe = classeRepository.findById(classeId).get();

        List<Module> modules = classe.getModules();
        List<Absence> absences;

        for (Module module: modules ) {
            absences = absenceRepository.getModuleAbsences(module.getId());
            for (Absence absence: absences) {
                absencesModel.add(new AbsenceModel(
                        absence.getId(),
                        absence.getStudent().getId(),
                        absence.getStudent().getNom() + " " +  absence.getStudent().getPrenom(),
                        absence.getStudent().getClasse().getId() ,
                        absence.getStudent().getClasse().getNom() ,
                        absence.getModule().getId() ,
                        absence.getModule().getNom() ,
                        absence.getNumberOfAbsence()
                        ));
            }
        }
        return absencesModel;
    }


}
