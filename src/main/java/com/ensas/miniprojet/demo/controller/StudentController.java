package com.ensas.miniprojet.demo.controller;
import com.ensas.miniprojet.demo.entity.CertifRequest;
import com.ensas.miniprojet.demo.entity.Student;
import com.ensas.miniprojet.demo.service.studentService.StudentService;
import com.ensas.miniprojet.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private JwtUtil jwtUtil = new JwtUtil();

    @Autowired
    StudentService studentService;

    @PostMapping("/newCertificationRequest")
    public String newCertificationRequest(@RequestBody CertifRequest certifRequest){
        System.out.println("callinf post.....................");
        String token = certifRequest.getJwt();
        System.out.println("callinf jwt........."+ token);
        System.out.println("callinf typecert........."+ certifRequest.getTypeCertificat());
        String userName = jwtUtil.extractUsername(token);
        System.out.println(userName);
        Student student = studentService.getStudent(userName);
        certifRequest.setStudent(student);
        certifRequest.setDateDeDemande(Date.valueOf(LocalDate.now()));
        System.out.println("====================>" +certifRequest);
        CertifRequest certifRequest1 =  studentService.addNewCertifRequest(certifRequest);
        System.out.println(certifRequest1);
        return "200";
    }

    @GetMapping("/myCertifications/{token}")
    public List<CertifRequest> myCertifications(@PathVariable String token){
        System.out.println("........Calling my certifications");
        System.out.println(token);
        String userName = jwtUtil.extractUsername(token);
        System.out.println(userName);
        Student student = studentService.getStudent(userName);

        return studentService.myCertifications(student);
        //return null;

    }
}
