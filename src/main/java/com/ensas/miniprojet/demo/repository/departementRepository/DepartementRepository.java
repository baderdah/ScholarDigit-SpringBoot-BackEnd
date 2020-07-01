package com.ensas.miniprojet.demo.repository.departementRepository;

import com.ensas.miniprojet.demo.entity.Departement;
import com.ensas.miniprojet.demo.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement,Long> {
}
