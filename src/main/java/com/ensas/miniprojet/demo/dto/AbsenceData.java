package com.ensas.miniprojet.demo.dto;

import java.util.ArrayList;

public class AbsenceData {

    ArrayList<Long> absentStudent;
    Long classeId;
    Long lessonId;
    int duration;

    public ArrayList<Long> getAbsentStudent() {
        return absentStudent;
    }

    public void setAbsentStudent(ArrayList<Long> absentStudent) {
        this.absentStudent = absentStudent;
    }

    public Long getClasseId() {
        return classeId;
    }

    public void setClasseId(Long classeId) {
        this.classeId = classeId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "AbsenceData{" +
                "absentStudent=" + absentStudent +
                ", classeId=" + classeId +
                ", lessonId=" + lessonId +
                ", duration=" + duration +
                '}';
    }
}

