package com.devweb.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String numCompte;

    @NotBlank
    @Size(max = 50)
    private int solde;

    @JoinColumn(name = "partenaire_id",referencedColumnName = "id")
    @ManyToOne(optional=false)
    @JsonIgnoreProperties("compte")
    private Partenaire partenaire;

    @OneToMany(mappedBy = "compte")
    @JsonIgnoreProperties("compte")
    private List<User> user;

    @OneToMany(mappedBy = "compte")
    @JsonIgnoreProperties("compte")
    private List<Depot> depots;


}
