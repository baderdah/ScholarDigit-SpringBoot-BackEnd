package com.ensas.miniprojet.demo.repository.moduleRepository;

import com.ensas.miniprojet.demo.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
}
