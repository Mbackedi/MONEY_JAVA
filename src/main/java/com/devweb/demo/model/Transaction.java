package com.devweb.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min = 3,max = 20)
    private int code;

    @NotBlank
    @Size(min = 3, max = 50)
    private int montant;

    @NotBlank
    @Size(min = 3, max = 50)
    private int frais;

    @NotBlank
    @Size(min = 3, max = 50)
    private int total;

    @NotBlank
    @Size(min = 3, max = 50)
    private int commiSup;

    @NotBlank
    @Size(min = 3, max = 50)
    private int commiParte;

    @NotBlank
    @Size(min = 3, max = 50)
    private int CommiEtat;


    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd-mm-ss")
    private Date dateDenvoie;


    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd-mm-ss")
    private Date dateRetrait;

    @NotBlank
    @Size(min = 3, max = 50)
    private String typeDoperation;

    @NotBlank
    @Size(min = 3, max = 50)
    private int numeroTransaction;

    @NotBlank
    @Size(min = 3, max = 50)
    private String nomExp;

    @NotBlank
    @Size(min = 3, max = 50)
    private String prenomExp;

    @NotBlank
    @Size(min = 3, max = 50)
    private String telephoneExp;

    @NotBlank
    @Size(min = 3, max = 50)
    private String addresseExp;

    @NotBlank
    @Size(min = 3, max = 50)
    private int numeropieceExp;

    @NotBlank
    @Size(min = 3, max = 50)
    private String typepieceExp;

    @NotBlank
    @Size(min = 3, max = 50)
    private String nomBen;

    @NotBlank
    @Size(min = 3, max = 50)
    private String prenomBen;

    @NotBlank
    @Size(min = 3, max = 50)
    private String telephoneBen;

    @NotBlank
    @Size(min = 3, max = 50)
    private String addresseBen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public int getFrais() {
        return frais;
    }

    public void setFrais(int frais) {
        this.frais = frais;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCommiSup() {
        return commiSup;
    }

    public void setCommiSup(int commiSup) {
        this.commiSup = commiSup;
    }

    public int getCommiParte() {
        return commiParte;
    }

    public void setCommiParte(int commiParte) {
        this.commiParte = commiParte;
    }

    public int getCommiEtat() {
        return CommiEtat;
    }

    public void setCommiEtat(int commiEtat) {
        CommiEtat = commiEtat;
    }

    public Date getDateDenvoie() {
        return dateDenvoie;
    }

    public void setDateDenvoie(Date dateDenvoie) {
        this.dateDenvoie = dateDenvoie;
    }

    public Date getDateRetrait() {
        return dateRetrait;
    }

    public void setDateRetrait(Date dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    public String getTypeDoperation() {
        return typeDoperation;
    }

    public void setTypeDoperation(String typeDoperation) {
        this.typeDoperation = typeDoperation;
    }

    public int getNumeroTransaction() {
        return numeroTransaction;
    }

    public void setNumeroTransaction(int numeroTransaction) {
        this.numeroTransaction = numeroTransaction;
    }

    public String getNomExp() {
        return nomExp;
    }

    public void setNomExp(String nomExp) {
        this.nomExp = nomExp;
    }

    public String getPrenomExp() {
        return prenomExp;
    }

    public void setPrenomExp(String prenomExp) {
        this.prenomExp = prenomExp;
    }

    public String getTelephoneExp() {
        return telephoneExp;
    }

    public void setTelephoneExp(String telephoneExp) {
        this.telephoneExp = telephoneExp;
    }

    public String getAddresseExp() {
        return addresseExp;
    }

    public void setAddresseExp(String addresseExp) {
        this.addresseExp = addresseExp;
    }

    public int getNumeropieceExp() {
        return numeropieceExp;
    }

    public void setNumeropieceExp(int numeropieceExp) {
        this.numeropieceExp = numeropieceExp;
    }

    public String getTypepieceExp() {
        return typepieceExp;
    }

    public void setTypepieceExp(String typepieceExp) {
        this.typepieceExp = typepieceExp;
    }

    public String getNomBen() {
        return nomBen;
    }

    public void setNomBen(String nomBen) {
        this.nomBen = nomBen;
    }

    public String getPrenomBen() {
        return prenomBen;
    }

    public void setPrenomBen(String prenomBen) {
        this.prenomBen = prenomBen;
    }

    public String getTelephoneBen() {
        return telephoneBen;
    }

    public void setTelephoneBen(String telephoneBen) {
        this.telephoneBen = telephoneBen;
    }

    public String getAddresseBen() {
        return addresseBen;
    }

    public void setAddresseBen(String addresseBen) {
        this.addresseBen = addresseBen;
    }

    public String getNumeropieceBen() {
        return numeropieceBen;
    }

    public void setNumeropieceBen(String numeropieceBen) {
        this.numeropieceBen = numeropieceBen;
    }

    public String getTypepieceBen() {
        return typepieceBen;
    }

    public void setTypepieceBen(String typepieceBen) {
        this.typepieceBen = typepieceBen;
    }

    @NotBlank
    @Size(min = 3, max = 50)
    private String numeropieceBen;

    @NotBlank
    @Size(min = 3, max = 50)
    private String typepieceBen;


}
