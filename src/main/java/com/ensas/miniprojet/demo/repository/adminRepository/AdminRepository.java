package com.ensas.miniprojet.demo.repository.adminRepository;

import com.ensas.miniprojet.demo.entity.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
}
