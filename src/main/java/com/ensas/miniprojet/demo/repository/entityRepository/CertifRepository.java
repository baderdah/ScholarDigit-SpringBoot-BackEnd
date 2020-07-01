package com.ensas.miniprojet.demo.repository.entityRepository;

import com.ensas.miniprojet.demo.entity.CertifRequest;
import com.ensas.miniprojet.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertifRepository extends JpaRepository<CertifRequest, Long> {
    @Query("SELECT c FROM CertifRequest c WHERE c.student = :student")
    public List<CertifRequest> find(@Param("student") Student student);
}
