package com.ensas.miniprojet.demo.repository.entityRepository;

import com.ensas.miniprojet.demo.entity.Classe;
import com.ensas.miniprojet.demo.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {

    @Query("SELECT distinct c FROM Classe c join fetch c.modules m join fetch m.prof p where p.email = :userName")
    List<Classe> getClasses(String userName);


    @Query("SELECT distinct m FROM Module m join fetch m.prof p where p.email = :userName")
    List<Module> getModules(String userName);
}
