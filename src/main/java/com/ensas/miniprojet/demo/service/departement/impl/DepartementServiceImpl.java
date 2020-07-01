package com.ensas.miniprojet.demo.service.departement.impl;

import com.ensas.miniprojet.demo.entity.Departement;
import com.ensas.miniprojet.demo.repository.departementRepository.DepartementRepository;
import com.ensas.miniprojet.demo.service.departement.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartementServiceImpl implements DepartementService {

    @Autowired
    DepartementRepository departementRepository;

    @Override
    @Transactional
    public List<Departement> getDepartements() {
        return departementRepository.findAll();
    }

    @Override
    @Transactional
    public Departement getDepartement(Long departementId) {
        return departementRepository.findById(departementId).get();
    }

    @Override
    @Transactional
    public Departement addDepartemente(Departement departement) {
        return departementRepository.save(departement);
    }

    @Override
    @Transactional
    public void delDepartement(Long departementId) {
         departementRepository.deleteById(departementId);
    }

    @Override
    @Transactional
    public Departement updateDepartement(Departement departement) {
        return departementRepository.save(departement);
    }
}