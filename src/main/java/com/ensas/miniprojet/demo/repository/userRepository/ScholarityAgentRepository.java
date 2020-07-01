package com.ensas.miniprojet.demo.repository.userRepository;

import com.ensas.miniprojet.demo.entity.ScolarityAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholarityAgentRepository extends JpaRepository<ScolarityAgent,Long> {

    ScolarityAgent findByEmail(String email);


}
