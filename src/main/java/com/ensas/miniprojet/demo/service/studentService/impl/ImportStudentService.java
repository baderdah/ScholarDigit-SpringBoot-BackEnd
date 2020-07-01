package com.ensas.miniprojet.demo.service.studentService.impl;

import com.ensas.miniprojet.demo.entity.Classe;
import com.ensas.miniprojet.demo.entity.Module;
import com.ensas.miniprojet.demo.entity.Student;
import com.ensas.miniprojet.demo.model.AbsenceModel;
import com.ensas.miniprojet.demo.service.classe.ClasseService;
import com.ensas.miniprojet.demo.service.studentService.StudentService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class ImportStudentService {

    @Autowired
    StudentService studentService;

    @Autowired
    ClasseService classeService;

    public int ExcelToStudent(InputStream in, Long classe) throws IOException {
        int nb = 0;
        Classe classe1 = classeService.getClasse(classe);

        try (Workbook workbook = new XSSFWorkbook(in)) {
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            boolean firstligne = true;
            if(iterator.hasNext()){
                iterator.next();
            }

            while (iterator.hasNext()) {
                Student student = new Student();
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();


                String email = nextRow.getCell(0) == null ? "" : nextRow.getCell(0).getStringCellValue();
                String nom = nextRow.getCell(1) == null ? "" : nextRow.getCell(1).getStringCellValue();
                String prenom = nextRow.getCell(2) == null ? "" : nextRow.getCell(2).getStringCellValue();
                String cne = nextRow.getCell(3) == null ? "" : nextRow.getCell(3).getStringCellValue();
                String adresse = nextRow.getCell(4) == null ? "" : nextRow.getCell(4).getStringCellValue();
                String sexe = nextRow.getCell(5) == null ? "" : nextRow.getCell(5).getStringCellValue();
                Date dateN = new SimpleDateFormat("dd/MM/yyyy").parse(nextRow.getCell(6) == null ? "" : nextRow.getCell(6).getStringCellValue());

                String tel = nextRow.getCell(6) == null ? "" : nextRow.getCell(7).getStringCellValue();

                student.setClasse(classe1);
                student.setEmail(email);
                student.setNom(nom);
                student.setPrenom(prenom);
                student.setCne(cne);
                student.setAdresse(adresse);
                student.setSexe(sexe);
                student.setTel(tel);
                student.setDateN(dateN);

                Student std = studentService.addStudent(student);
                if(std != null){
                    ++nb;
                }

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    System.out.println(cell.getStringCellValue());
                    System.out.print(" ----- ");
                }
                System.out.println("-- next Ligne --");
            }

            workbook.close();
            in.close();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return nb;
    }
}
