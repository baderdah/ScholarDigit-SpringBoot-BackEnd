package com.ensas.miniprojet.demo.controller.prof;

import com.ensas.miniprojet.demo.dto.AbsenceData;
import com.ensas.miniprojet.demo.entity.Absence;
import com.ensas.miniprojet.demo.entity.Classe;
import com.ensas.miniprojet.demo.entity.Module;
import com.ensas.miniprojet.demo.entity.Student;
import com.ensas.miniprojet.demo.service.classe.ClasseService;
import com.ensas.miniprojet.demo.service.prof.ProfService;
import com.ensas.miniprojet.demo.service.scholarityService.impl.ExportAbsence;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/prof")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = {"Authorization", "content-type"})
public class ProfController {

    @Autowired
    ProfService profService;

    @Autowired
    ClasseService classeService;

    @Autowired
    ExportAbsence exportAbsence;

    @GetMapping("/classes")
    List<Classe> getClasses(HttpServletRequest request){
//        System.out.println("User Name " + request.getAttribute("userName"));
        return profService.getClassess(request.getAttribute("userName").toString());
    }

    @GetMapping("/classes/{classeId}/students")
    List<Student> getStudentOfClasse(@PathVariable Long classeId){
        return profService.getStudentOfClasse(classeId);
    }

    @GetMapping("/modules")
    List<Module> getModules(HttpServletRequest request){
//        System.out.println("User Name " + request.getAttribute("userName"));
        return profService.getModules(request.getAttribute("userName").toString());
    }

    @PostMapping("/absence")
    public void makAbsence(@RequestBody AbsenceData absenceData){
        profService.markAbsence(absenceData);
    }

    @GetMapping("/absence/student/{studentId}")
    public  List<Absence> getStudentAbsences(@PathVariable Long studentId){
        return  profService.getStudentAbsences(studentId);
    }

    @GetMapping("/absence/module/{moduleId}")
    public  List<Absence> getModuleAbsences(@PathVariable Long moduleId){
        return  profService.getModuleAbsences(moduleId);
    }

    @RequestMapping(path = "/classes/absence/{classeId}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<String> download(@PathVariable Long classeId) throws IOException {

        ByteArrayInputStream in = exportAbsence.AbsenceToExcel(classeId);
        // return IOUtils.toByteArray(in);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=customers.xlsx");
        headers.add("Content-Type", "application/octet-stream");
//        headers.add("Cache-Control", "no-cache, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

//        InputStreamResource finput = new InputStreamResource(in);
//        byte[] imageBytes = new byte[(int)finput.length()];
//        finput.read(imageBytes, 0, imageBytes.length);
//        finput.close();

        byte[] bytes = IOUtils.toByteArray(in);
        String fileStr = Base64.encodeBase64String( bytes);
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(fileStr);
    }
}
