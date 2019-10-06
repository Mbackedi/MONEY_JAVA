package com.devweb.demo.controller;

import com.devweb.demo.model.Partenaire;
import com.devweb.demo.model.RegisterUser;
import com.devweb.demo.model.User;
import com.devweb.demo.repository.PartenaireRepository;
import com.devweb.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PartenaireController {
@Autowired
PartenaireRepository partenaireRepository;
@PostMapping("/ajoutparte")
    public Partenaire ajout(Partenaire partenaire){
    partenaireRepository.save(partenaire);
    return partenaire;

}

//BLOQUER PARTENAIRE


    @PutMapping(value = "/statut/{id}",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<String> blockPartener (@PathVariable("id")int id) throws Exception {
        Partenaire etat= partenaireRepository.findById((int) id).orElseThrow(
                ()->new Exception ("Ce Partenaire n'existe pas")
        );


        if (etat.getStatut().equals("debloquer")){
            etat.setStatut("bloquer");
            partenaireRepository.save(etat);
            return new ResponseEntity<>(etat.getNomEntreprise()+ " a été bloqué", HttpStatus.OK);
        }
        else{
            etat.setStatut("debloquer");
            partenaireRepository.save(etat);
            return new ResponseEntity<>(etat.getNomEntreprise()+ " a été débloqué", HttpStatus.OK);
        }
    }





}
