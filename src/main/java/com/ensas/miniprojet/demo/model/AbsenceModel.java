package com.ensas.miniprojet.demo.model;

public class AbsenceModel {

    public Long id;
    public Long studentId;
    public String fullName;
    public Long classeId;
    public String classeName;
    public Long moduleId;
    public String moduleName;
    public int nbOfAbsence;

    public AbsenceModel(Long id, Long studentId, String fullName, Long classeId, String classeName, Long moduleId, String moduleName, int nbOfAbsence) {
        this.id = id;
        this.studentId = studentId;
        this.fullName = fullName;
        this.classeId = classeId;
        this.classeName = classeName;
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.nbOfAbsence = nbOfAbsence;
    }
}
