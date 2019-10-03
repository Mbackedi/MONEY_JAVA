package com.devweb.demo.repository;

import com.devweb.demo.model.Compte;
import com.devweb.demo.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {


}
