package com.ensas.miniprojet.demo.repository.filiereRepository;

import com.ensas.miniprojet.demo.entity.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {
}
