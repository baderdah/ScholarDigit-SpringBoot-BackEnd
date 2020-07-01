package com.ensas.miniprojet.demo.service.scholarityService;

import com.ensas.miniprojet.demo.entity.*;
import com.ensas.miniprojet.demo.entity.Student;
import com.ensas.miniprojet.demo.model.AbsenceModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface ScholarityService {
    List<Student> getStudentOfClasse(@RequestBody Long classeID);
    List<CertifRequest> getAllCertifRequest();
    List<AbsenceModel> getClasseAbsences(Long classeId);
}