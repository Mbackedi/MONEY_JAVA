package com.devweb.demo.controller;

import com.devweb.demo.model.AcountUser;
import com.devweb.demo.model.Depot;
import com.devweb.demo.model.RegisterUser;
import com.devweb.demo.model.User;
import com.devweb.demo.repository.DepotRepository;
import com.devweb.demo.repository.UserRepository;
import com.devweb.demo.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

// FAIRE UN DEPOT
@RestController
@CrossOrigin
@RequestMapping(value = "/security")
public class SecurityController {

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    DepotRepository depotRepository;
    @PostMapping(value = "/deposer",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<String> depot (@RequestBody(required = false) RegisterUser registerUser){
        Depot d = new Depot();
        d.setDatedepot(new Date());
        d.setMontant(registerUser.getMontant());
        d.setCompte(registerUser.getCompte());

        User user=userDetailsService.getUserConnecte();
        d.setUser(user);

        //ajout du montant du depot sur le solde du compte
        //Compte cpt= compteRepository.findById(registerUser.getCompte().getId()).orElseThrow();
        // cpt.setSolde(cpt.getSolde()+d.getMontant());
        //compteRepository.save(cpt);
        depotRepository.save(d);

        return new ResponseEntity<>("depot reussit", HttpStatus.OK);
    }

//ALOUER COMPTE A UN USER

    @Autowired
    UserRepository userRepository;
    @PostMapping(value = "/compteUser",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<String> addCompteUser (@RequestBody(required = false) AcountUser accountUser) throws Exception {
        User user= userRepository.findByUsername(accountUser.getUsername()).orElseThrow(
                ()->new Exception ("Ce username n'existe pas")
        );
        user.setUsername(accountUser.getUsername());
        user.setCompte(accountUser.getCompte());
        userRepository.save(user);

        return new ResponseEntity<>("Compte Utilsateur Ajouté Avec Succés", HttpStatus.OK);
    }



    //BLOQUER USER


    @PutMapping(value = "/statut/{id}",consumes =(MediaType.APPLICATION_JSON_VALUE))
    public ResponseEntity<String> blockUser (@PathVariable("id")long id) throws Exception {
        User etat= userRepository.findById(id).orElseThrow(
                ()->new Exception ("Ce user n'existe pas")
        );

        if(etat.getUsername().equals("kabirou")){
            return new ResponseEntity<>(etat.getUsername()+ " Ne peut pas être bloqué car c'est le super admin", HttpStatus.OK);
        }
        if (etat.getStatut().equals("debloquer")){
            etat.setStatut("bloquer");
            userRepository.save(etat);
            return new ResponseEntity<>(etat.getUsername()+ " a été bloqué", HttpStatus.OK);
        }
        else{
            etat.setStatut("debloquer");
            userRepository.save(etat);
            return new ResponseEntity<>(etat.getUsername()+ " a été débloqué", HttpStatus.OK);
        }
    }

}
