package com.ensas.miniprojet.demo.repository.certifRequestRepository;

import com.ensas.miniprojet.demo.entity.CertifRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CertifRequestRepository extends JpaRepository<CertifRequest, Long> {

}
