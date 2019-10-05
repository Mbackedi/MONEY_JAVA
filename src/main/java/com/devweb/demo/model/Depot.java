package com.devweb.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;


@Entity

public class Depot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private int montant;

    @DateTimeFormat(pattern = "yyyy-MM-dd-mm-ss")
    private Date datedepot;

    @JsonIgnore
    @JoinColumn(name = "compte_id",referencedColumnName = "id",nullable=true)
    @ManyToOne(optional=false)
    @JsonIgnoreProperties("depot")
    private Compte compte;

    @JsonIgnore
    @JoinColumn(name = "user_id",referencedColumnName = "id",nullable=true)
    @ManyToOne(optional=false)
    @JsonIgnoreProperties("user")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Date getDatedepot() {
        return datedepot;
    }

    public void setDatedepot(Date datedepot) {
        this.datedepot = datedepot;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
