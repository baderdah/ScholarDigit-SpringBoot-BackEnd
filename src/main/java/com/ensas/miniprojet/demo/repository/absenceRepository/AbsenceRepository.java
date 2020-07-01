package com.ensas.miniprojet.demo.repository.absenceRepository;

import com.ensas.miniprojet.demo.entity.Absence;
import com.ensas.miniprojet.demo.entity.Module;
import com.ensas.miniprojet.demo.entity.Student;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {

    Absence findByModuleAndAndStudent(Module module, Student student);

    @Query("SELECT a FROM Absence a where a.module.id = :module AND a.student.id = :student")
    Absence getAbsence(Long module, Long student);

    @Query("SELECT a FROM Absence a where a.student.id = :student")
    List<Absence> getStudentAbsences(Long student);

    @Query("SELECT a FROM Absence a where a.module.id = :module ")
    List<Absence> getModuleAbsences(Long module);



}
