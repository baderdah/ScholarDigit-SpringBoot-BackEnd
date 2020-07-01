package com.ensas.miniprojet.demo.service.studentService.impl;

import com.ensas.miniprojet.demo.entity.CertifRequest;
import com.ensas.miniprojet.demo.entity.Identification;
import com.ensas.miniprojet.demo.entity.Student;
import com.ensas.miniprojet.demo.repository.entityRepository.CertifRepository;
import com.ensas.miniprojet.demo.repository.userRepository.StudentRepository;
import com.ensas.miniprojet.demo.service.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    CertifRepository certifRepository;


    @Override
    @Transactional
    public CertifRequest addNewCertifRequest(CertifRequest certifRequest) {

        CertifRequest certifRequest1 = certifRepository.save(certifRequest);
        return certifRequest1;
    }

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Student getStudent(String mail){return studentRepository.findByEmail(mail);}

    @Override
    public Student addStudent(Student student) {
        Student std = studentRepository.findByEmail(student.getEmail());
        if(std == null){
            student.setIdentification(new Identification(student.getEmail(),student.getEmail()));
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public void delStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<CertifRequest> myCertifications(Student student) {
        return certifRepository.find(student);
    }
}

