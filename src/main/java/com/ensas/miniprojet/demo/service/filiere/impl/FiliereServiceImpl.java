package com.ensas.miniprojet.demo.service.filiere.impl;

import com.ensas.miniprojet.demo.entity.Filiere;
import com.ensas.miniprojet.demo.repository.filiereRepository.FiliereRepository;
import com.ensas.miniprojet.demo.service.filiere.FiliereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FiliereServiceImpl implements FiliereService {

    @Autowired
    FiliereRepository filiereRepository;

    @Override
    @Transactional
    public List<Filiere> getFilieres() {
        return filiereRepository.findAll();
    }

    @Override
    @Transactional
    public Filiere getFiliere(Long filiereId) {
        return filiereRepository.findById(filiereId).get();
    }

    @Override
    @Transactional
    public Filiere addFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    @Override
    @Transactional
    public void delFiliere(Long filiereId) {
         filiereRepository.deleteById(filiereId);
    }

    @Override
    @Transactional
    public Filiere updateFiliere(Filiere filiere) {
        return filiereRepository.save(filiere);
    }
}
