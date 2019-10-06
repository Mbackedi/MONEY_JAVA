package com.devweb.demo.controller;

import com.devweb.demo.model.*;
import com.devweb.demo.repository.CompteRepository;
import com.devweb.demo.repository.DepotRepository;
import com.devweb.demo.repository.PartenaireRepository;
import com.devweb.demo.repository.UserRepository;
import com.devweb.demo.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    UserRepository userRepository;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/lister")
    public List<User> lister (){
        return userRepository.findAll();
    }
    @Autowired
    PasswordEncoder encoder;
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @PostMapping(value = "/add",consumes =(MediaType.APPLICATION_JSON_VALUE))
      public User ajout (@RequestBody(required = false)RegisterUser registerUser){
        User us =new User();
        us.setEmail(registerUser.getEmail());
        us.setName(registerUser.getName());
        us.setUsername(registerUser.getUsername());
        us.setPassword(encoder.encode(registerUser.getPassword()));
        us.setTelephone(registerUser.getTelephone());
        us.setStatut("debloquer");

        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(registerUser.getProfil());
        roles.add(role);
        us.setRoles(roles);

       /* User user = userDetailsService.getUserConnecte();
        user.getPartenaire();
        us.setPartenaire(user.getPartenaire());*/
        userRepository.save(us);
        return userRepository.save(us);
    }


   @Autowired
    PartenaireRepository partenaireRepository;
    @Autowired
    CompteRepository compteRepository;
    @PostMapping(value = "/addPartener", consumes = (MediaType.APPLICATION_JSON_VALUE))
    public Partenaire add(@RequestBody(required = false) RegisterUser registerUser) {

        //AJOUT PARTENAIRE
        Partenaire p = new Partenaire();
        p.setRS(registerUser.getRS());
        p.setNomEntreprise(registerUser.getNomEntreprise());
        p.setAddresse(registerUser.getAddresse());
        p.setNinea(registerUser.getNinea());
        p.setStatut("debloquer");
        partenaireRepository.save(p);

        //AJOUT COMPTE
        Compte c = new Compte();
        // String nb;
        // nb = "MA"+(10000+(int) Math.random()*(99999-10000));
        SimpleDateFormat formater = null;

        formater = new SimpleDateFormat("ssyyyyMMddHHmm");
        Date now=new Date();
        String numcompt = formater.format(now);

        c.setNumCompte(numcompt);
        //c.setNumeroCompte(nb);
        c.setPartenaire(p);
        c.setSolde(750000);
       // c.setUser(u);
        compteRepository.save(c);

        //AJOUT UTILISATEUR
        User u = new User();
        u.setUsername(registerUser.getUsername());
        u.setName(registerUser.getName());
        u.setPassword(encoder.encode(registerUser.getPassword()));
        u.setTelephone(registerUser.getTelephone());
        u.setEmail(registerUser.getEmail());
        u.setStatut("debloquer");
        Set<Role> roles =new HashSet<>();
        Role role =new Role();
        role.setId(registerUser.getProfil());
        roles.add(role);
        u.setRoles(roles);
        u.setPartenaire(p);
        userRepository.save(u);

        return partenaireRepository.save(p);
    }


}
