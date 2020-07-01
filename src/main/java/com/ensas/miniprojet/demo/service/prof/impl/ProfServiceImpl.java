package com.ensas.miniprojet.demo.service.prof.impl;
import com.ensas.miniprojet.demo.dto.AbsenceData;
import com.ensas.miniprojet.demo.entity.*;
import com.ensas.miniprojet.demo.repository.absenceRepository.AbsenceRepository;
import com.ensas.miniprojet.demo.repository.entityRepository.ClasseRepository;
import com.ensas.miniprojet.demo.repository.userRepository.ProfRepository;
import com.ensas.miniprojet.demo.repository.userRepository.StudentRepository;
import com.ensas.miniprojet.demo.service.prof.ProfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfServiceImpl implements ProfService {

    @Autowired
    ClasseRepository classeRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ProfRepository profRepository;

    @Autowired
    AbsenceRepository absenceRepository;

    @Override
    @Transactional
    public List<Classe> getClassess(String userName) {
        return classeRepository.getClasses(userName);
    }

    @Override
    @Transactional
    public List<Module> getModules(String userName) {
        return classeRepository.getModules(userName);
    }

    @Override
    @Transactional
    public List<Student> getStudentOfClasse(Long classeID) {
        List<Student> students = studentRepository.findByClasse_Id(classeID);
        return students;
    }

    @Override
    @Transactional
    public List<Prof> getProfs() {
        return profRepository.findAll();
    }

    @Override
    @Transactional
    public Prof getProf(Long profId) {
        return profRepository.findById(profId).get();
    }

    @Override
    @Transactional
    public Prof addProf(Prof prof) {
        prof.setIdentification(new Identification(prof.getEmail(), prof.getEmail()));
        System.out.println("adding new Prof");
        System.out.println(prof);
        return profRepository.save(prof);
    }

    @Override
    public void delProf(Long profId) {
        profRepository.deleteById(profId);
    }

    @Override
    public Prof updateProf(Prof prof)
    {
        Prof newprof = getProf(prof.getId());
        if(newprof != null){
            newprof.setIdentification(prof.getIdentification());
        }
        return profRepository.save(prof);
    }


    @Override
    @Transactional
    public void markAbsence(AbsenceData absenceData){

        for (Long st: absenceData.getAbsentStudent()
             ) {
            Absence absence = absenceRepository.getAbsence(absenceData.getLessonId(),st);
            if(absence == null){
                absence = new Absence();
                Student student = new Student();
                student.setId(st);
                Module module = new Module();
                module.setId(absenceData.getLessonId());
                absence.setNumberOfAbsence(0);
                absence.setStudent(student);
                absence.setModule(module);
                absence.setNumberOfAbsence(absence.getNumberOfAbsence() + absenceData.getDuration());
                absenceRepository.save(absence);
            }else{
                absence.setNumberOfAbsence(absence.getNumberOfAbsence() + absenceData.getDuration());

            }
        }
    }

    @Override
    @Transactional
    public List<Absence> getStudentAbsences(Long studentId){
        return absenceRepository.getStudentAbsences(studentId);
    }

    @Override
    @Transactional
    public List<Absence> getModuleAbsences(Long moduleId){
        return absenceRepository.getStudentAbsences(moduleId);
    }



}
