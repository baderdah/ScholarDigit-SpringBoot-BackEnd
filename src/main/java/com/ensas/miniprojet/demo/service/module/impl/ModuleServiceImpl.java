package com.ensas.miniprojet.demo.service.module.impl;

import com.ensas.miniprojet.demo.entity.Module;
import com.ensas.miniprojet.demo.repository.moduleRepository.ModuleRepository;
import com.ensas.miniprojet.demo.service.module.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    ModuleRepository moduleRepository;

    @Override
    @Transactional
    public List<Module> getModules() {
        return moduleRepository.findAll();
    }

    @Override
    @Transactional
    public Module getModule(Long moduleId) {
        return moduleRepository.findById(moduleId).get();
    }

    @Override
    @Transactional
    public Module addModule(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    @Transactional
    public void delModule(Long moduleId) {
        moduleRepository.deleteById(moduleId);
    }

    @Override
    @Transactional
    public Module updateModule(Module module) {
        return moduleRepository.save(module);
    }
}
