package com.ensas.miniprojet.demo.repository.userRepository;

import com.ensas.miniprojet.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {



    Student findByEmail(String email);

    List<Student> findByClasse_Id(Long classeId);
}
