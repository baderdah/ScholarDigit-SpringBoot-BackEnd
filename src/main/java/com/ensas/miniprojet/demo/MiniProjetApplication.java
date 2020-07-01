package com.ensas.miniprojet.demo;

import com.ensas.miniprojet.demo.entity.Identification;
import com.ensas.miniprojet.demo.entity.ScolarityAgent;
import com.ensas.miniprojet.demo.repository.userRepository.ScholarityAgentRepository;
import com.ensas.miniprojet.demo.service.scholarityService.ScholarityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class MiniProjetApplication {

	@Autowired
	ScholarityAgentRepository scholarityAgentRepository;
	public void seedInitData(){

		List<ScolarityAgent> agents = scholarityAgentRepository.findAll();
		if(agents.size() == 0){
			ScolarityAgent scolarityAgent = new ScolarityAgent();
			Identification identification = new Identification();
			identification.setPassword("password");
			identification.setUsername("scholarity");
			scolarityAgent.setEmail("scholarity");
			scolarityAgent.setNom("scholarity");
			scolarityAgent.setIdentification(identification);
			scolarityAgent.setPrenom("scholarity");

			scholarityAgentRepository.save(scolarityAgent);
			System.out.println("seeding");
		}
	}


	@EventListener
	public void seed(ContextRefreshedEvent event) {
		seedInitData();

	}


	public static void main(String[] args) {
		SpringApplication.run(MiniProjetApplication.class, args);
	}

}
