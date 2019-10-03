package com.devweb.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Partenaire {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 50)
    private String RS;

    @NotBlank
    @Size(min=3, max = 50)
    private String ninea;

    @NotBlank
    @Size(min=3, max = 50)
    private String addresse;

    @NotBlank
    @Size(min=3, max = 50)
    private String statut;

    @NotBlank
    @Size(min=3, max = 50)
    private String nomEntreprise;

    @OneToMany(mappedBy = "partenaire")
    @JsonIgnoreProperties("partenaire")
    private List<Compte> comptes;

    @OneToMany(mappedBy = "partenaire")
    @JsonIgnoreProperties("partenaire")
    private List<User> users;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getRS() {
        return RS;
    }

    public void setRS(String RS) {
        this.RS = RS;
    }

    public String getNinea() {
        return ninea;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }


}
