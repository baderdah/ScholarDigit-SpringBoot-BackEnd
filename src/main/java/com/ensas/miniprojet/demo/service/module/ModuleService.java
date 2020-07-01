package com.ensas.miniprojet.demo.service.module;

import com.ensas.miniprojet.demo.entity.Module;

import java.util.List;

public interface ModuleService {
    List<Module> getModules();
    Module getModule(Long moduleId);
    Module addModule(Module module);
    void delModule(Long moduleId);
    Module updateModule(Module module);
}
