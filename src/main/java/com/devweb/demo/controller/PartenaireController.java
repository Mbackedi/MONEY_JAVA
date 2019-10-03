package com.devweb.demo.controller;

import com.devweb.demo.model.Partenaire;
import com.devweb.demo.repository.PartenaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartenaireController {
@Autowired
    PartenaireRepository partenaireRepository;
@PostMapping("/ajoutparte")
    public Partenaire ajout(Partenaire partenaire){
    partenaireRepository.save(partenaire);
    return partenaire;

}
}
