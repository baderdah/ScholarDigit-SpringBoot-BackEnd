package com.ensas.miniprojet.demo.controller.Scholarity;
import com.ensas.miniprojet.demo.entity.*;
import com.ensas.miniprojet.demo.entity.Prof;
import com.ensas.miniprojet.demo.entity.Student;
import com.ensas.miniprojet.demo.model.AbsenceModel;
import com.ensas.miniprojet.demo.service.CertifRequest.CertifRequestService;
import com.ensas.miniprojet.demo.service.classe.ClasseService;
import com.ensas.miniprojet.demo.service.departement.DepartementService;
import com.ensas.miniprojet.demo.service.filiere.FiliereService;
import com.ensas.miniprojet.demo.service.module.ModuleService;
import com.ensas.miniprojet.demo.service.prof.ProfService;
import com.ensas.miniprojet.demo.service.scholarityService.ScholarityService;
import com.ensas.miniprojet.demo.service.scholarityService.impl.ExportAbsence;
import com.ensas.miniprojet.demo.service.studentService.StudentService;
import com.ensas.miniprojet.demo.service.studentService.impl.ImportStudentService;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/scholarity")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = {"Authorization", "content-type"})
public class ScholarityController {

    @Autowired
    ScholarityService scholarityService;

    @Autowired
    ClasseService classeService;

    @Autowired
    ProfService profService;

    @Autowired
    StudentService studentService;

    @Autowired
    FiliereService filiereService;

    @Autowired
    ModuleService moduleService;

    @Autowired
    ExportAbsence exportAbsence;

    @Autowired
    DepartementService departementService;

    @Autowired
    CertifRequestService certifRequestService;

    @Autowired
    ImportStudentService importStudentService;

    @GetMapping("/modules")
    @CrossOrigin(origins = "http://localhost:3000")
    List<Module> getModules(){
        return moduleService.getModules();
    }
    @GetMapping("/modules/{moduleId}")
    Module getModule(@PathVariable Long moduleId){
        return moduleService.getModule(moduleId);
    }
    @PostMapping("/modules")
    Module addModule(@RequestBody Module module){
        return moduleService.updateModule(module);
    }
    @DeleteMapping("/modules/{moduleId}")
    void delModule(@PathVariable Long moduleId){
        moduleService.delModule(moduleId);
    }
    @PutMapping("/modules")
    Module updateModule(@RequestBody Module module){
        return moduleService.updateModule(module);
    }


    @GetMapping("/departements")
    @CrossOrigin(origins = "http://localhost:3000")
    List<Departement> getDepartements(){
        return departementService.getDepartements();
    }
    @GetMapping("/departements/{departementId}")
    Departement getDepartement(@PathVariable Long departementId){
        return departementService.getDepartement(departementId);
    }
    @PostMapping("/departements")
    Departement addDepartement(@RequestBody Departement departement){
        return departementService.updateDepartement(departement);
    }
    @DeleteMapping("/departements/{departementId}")
    void delDepartement(@PathVariable Long departementId){
        departementService.delDepartement(departementId);
    }
    @PutMapping("/departements")
    Departement updateDepartement(@RequestBody Departement departement){
        return departementService.updateDepartement(departement);
    }

    @GetMapping("/profs")
    List<Prof> getProfs(){
        System.out.println(profService.getProfs());
        return profService.getProfs();
    }
    @GetMapping("/profs/{profId}")
    Prof getProf(@PathVariable Long profId){
        return profService.getProf(profId);
    }
    @PostMapping("/profs")
    Prof addProf(@RequestBody Prof prof){
        return profService.addProf(prof);
    }
    @DeleteMapping("/profs/{profId}")
    void delProf(@PathVariable Long profId){
        profService.delProf(profId);
    }
    @PutMapping("/profs")
    Prof updateProf(@RequestBody Prof prof){
        return profService.updateProf(prof);
    }


    @GetMapping("/filieres")
    List<Filiere> getFilieres(){
        System.out.println(filiereService.getFilieres());
        return filiereService.getFilieres();
    }

    @GetMapping("/filieres/{filiereId}")
    Filiere getFiliere(@PathVariable Long filiereId){
        return filiereService.getFiliere(filiereId);
    }
    @PostMapping("/filieres")
    Filiere addFiliere(@RequestBody Filiere filiere){
        return filiereService.updateFiliere(filiere);
    }
    @DeleteMapping("/filieres/{filiereId}")
    void delFiliere(@PathVariable Long filiereId){
        filiereService.delFiliere(filiereId);
    }
    @PutMapping("/filieres")
    Filiere updateFiliere(@RequestBody Filiere filiere){
        return filiereService.updateFiliere(filiere);
    }


    @GetMapping("/classes")
    List<Classe>  getClasses(){
        List<Classe> classes = classeService.getClasses();
        return classes;
    }
     
    @GetMapping("/classes/{classeId}")
    Classe getClasse(@PathVariable Long classeId){
        return classeService.getClasse(classeId);
    }

    @GetMapping("/classes/{classeId}/students")
    List<Student> getStudentOfClasse(@PathVariable Long classeId){
        return scholarityService.getStudentOfClasse(classeId);
    }

    @PostMapping("/classes")
    Classe addClasse(@RequestBody Classe classe){
        return classeService.updateClasse(classe);
    }
    @DeleteMapping("/classes/{classeId}")
    void delClasse(@PathVariable Long classeId){
        classeService.delClasse(classeId);
    }
    @PutMapping("/classes")
    Classe updateClasse(@RequestBody Classe classe){
        return classeService.updateClasse(classe);
    }



    @GetMapping("/students/{studentId}")
    Student getStudent(@PathVariable Long studentId){
        return studentService.getStudent(studentId);
    }
    @PostMapping("/students")
    Student addStudent(@RequestBody Student student){

        return studentService.addStudent(student);
    }
    @DeleteMapping("/students/{studentId}")
    void delStudent(@PathVariable Long studentId){
        studentService.delStudent(studentId);
    }
    @PutMapping("/students")
    Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @GetMapping("/certifRequests")
    List<CertifRequest>  getCertifRequests(){
        List<CertifRequest> certifRequests = certifRequestService.getCertifRequests();
        return certifRequests;
    }
    @GetMapping("/certifRequests/{certifRequestId}")
    CertifRequest getCertifRequest(@PathVariable Long certifRequestId){
        return certifRequestService.getCertifRequest(certifRequestId);
    }

    @PostMapping("/certifRequests")
    CertifRequest addCertifRequest(@RequestBody CertifRequest certifRequest){
        return certifRequestService.updateCertifRequest(certifRequest);
    }
    @DeleteMapping("/certifRequests/{certifRequestId}")
    void delCertifRequest(@PathVariable Long certifRequestId){
        certifRequestService.delCertifRequest(certifRequestId);
    }
    @PutMapping("/certifRequests")
    CertifRequest updateCertifRequest(@RequestBody CertifRequest certifRequest){
        return certifRequestService.updateCertifRequest(certifRequest);
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

    @RequestMapping(path = "/students/import", method = RequestMethod.POST)
    public int uploadFile(MultipartFile file, Long classeID) throws IOException {
        System.out.println("[INfo] +++++++> " + classeID);
        InputStream in = file.getInputStream();
        int nb = importStudentService.ExcelToStudent(in, classeID);
        return nb;
    }



//    @RequestMapping(path="/downloadFile",method=RequestMethod.GET)
////    @Consumes(MediaType.APPLICATION_JSON_VALUE)
//    public  ResponseEntity<ByteArrayResource> downloadDocument(
//            String acquistionId,
//            String fileType,
//            Integer expressVfId) throws IOException {
//        File file = new File("src/main/resources/image/profile.png");
//        Path path = Paths.get(file.getAbsolutePath());
//        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
//        headers.add("Pragma", "no-cache");
//        headers.add("Expires", "0");
////        return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
//        return ResponseEntity.ok()
//                .headers(headers)
//                .contentLength(file.length())
//                .contentType(MediaType.parseMediaType("application/octet-stream"))
//                .body(resource);
//    }



}