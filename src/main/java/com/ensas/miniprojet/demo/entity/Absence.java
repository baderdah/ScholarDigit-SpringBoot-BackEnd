package com.ensas.miniprojet.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numberOfAbsence;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Student student;

    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Module module;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumberOfAbsence() {
        return numberOfAbsence;
    }

    public void setNumberOfAbsence(Integer numberOfAbsence) {
        this.numberOfAbsence = numberOfAbsence;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return "Absence{" +
                "id=" + id +
                ", numberOfAbsence=" + numberOfAbsence +
                ", student=" + student +
                ", module=" + module +
                '}';
    }
}
