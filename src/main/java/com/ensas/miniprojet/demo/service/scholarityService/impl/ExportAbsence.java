package com.ensas.miniprojet.demo.service.scholarityService.impl;

import com.ensas.miniprojet.demo.entity.Classe;
import com.ensas.miniprojet.demo.entity.Module;
import com.ensas.miniprojet.demo.entity.Student;
import com.ensas.miniprojet.demo.model.AbsenceModel;
import com.ensas.miniprojet.demo.repository.absenceRepository.AbsenceRepository;
import com.ensas.miniprojet.demo.repository.entityRepository.ClasseRepository;
import com.ensas.miniprojet.demo.service.classe.ClasseService;
import com.ensas.miniprojet.demo.service.scholarityService.ScholarityService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExportAbsence {

    @Autowired
    ClasseRepository classeRepository;

    @Autowired
    ScholarityService scholarityService;

    public ByteArrayInputStream AbsenceToExcel(Long classeId) throws IOException {

        Classe classe = classeRepository.findById(classeId).get();

        List<Module> modules = classe.getModules();
        List<Student> students = classe.getStudents();
        HashMap<Long, Integer> mapRowStudent = new HashMap<Long, Integer>();
        HashMap<Long, Integer> mapColModule  = new HashMap<Long, Integer>();


        try (Workbook workbook = new XSSFWorkbook()) {
            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                CreationHelper createHelper = workbook.getCreationHelper();

                Sheet sheet = workbook.createSheet("Customers");

                Font headerFont = workbook.createFont();
                headerFont.setBold(true);
                headerFont.setColor(IndexedColors.BLUE.getIndex());

                CellStyle headerCellStyle = workbook.createCellStyle();
                headerCellStyle.setFont(headerFont);

                // Row for Header
                Row headerRow = sheet.createRow(0);

                // Header
                int col = 0;
                Cell cell = headerRow.createCell(col);
                cell.setCellValue("Full Name");
                cell.setCellStyle(headerCellStyle);
                col++;
                for (Module module : modules) {
                    cell = headerRow.createCell(col);
                    cell.setCellValue(module.getNom());
                    cell.setCellStyle(headerCellStyle);
                    mapColModule.put(module.getId(), col);
                    col++;
                }

//                // CellStyle for Age
//                CellStyle ageCellStyle = workbook.createCellStyle();
//                ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));
                int rowId = 1;
                for(Student student : students){
                    Row row = sheet.createRow(rowId++);
                    row.createCell(0).setCellValue(student.getNom() + " " + student.getPrenom());
                    mapRowStudent.put(student.getId(), rowId);
                }
                List<AbsenceModel> absenceModels = scholarityService.getClasseAbsences(classeId);

                for (AbsenceModel absence:absenceModels) {
                    try {
                        int studentRowId = mapRowStudent.get(absence.studentId)-1;
                        int moduleColId = mapColModule.get(absence.moduleId);
                        if(studentRowId >= 1){
                            Row row = sheet.getRow(studentRowId);
                            row.createCell(moduleColId).setCellValue(absence.nbOfAbsence);
                        }
                    }catch (Exception e){
                    }


                }
                workbook.write(out);
                return new ByteArrayInputStream(out.toByteArray());
            }
        }
    }

}
