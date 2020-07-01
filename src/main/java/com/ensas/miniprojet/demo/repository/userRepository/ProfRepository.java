package com.ensas.miniprojet.demo.repository.userRepository;

import com.ensas.miniprojet.demo.entity.Identification;
import com.ensas.miniprojet.demo.entity.Prof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfRepository extends JpaRepository<Prof,Long> {
    /**
     * this fucntion is for finding an existing Prof by their identification.
     * @param identification
     * @return Prof
     */
    public Prof findByIdentification(Identification identification);

    /**
     * this fucntion is for finding an existing Prof by their email address.
     * @param email
     * @return Prof
     */
    public Prof findByEmail(String email);
}
