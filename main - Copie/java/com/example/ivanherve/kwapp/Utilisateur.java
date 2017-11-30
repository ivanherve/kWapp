package com.example.ivanherve.kwapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/**
 * Created by Ivan HERVE on 18-11-17.
 */

public class Utilisateur {

    private String idUser;
    private String nom;
    private String prenom;
    private String pseudo;
    private String email;
    private String motDePasse;
    private int age;
    private String userSql = "kwapp";
    private String passwordSql = "P@ss0rd";

    public Utilisateur(String idUser, String nom, String prenom, String pseudo, String email, String motDePasse, int age) {this.idUser = idUser;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.email = email;
        this.motDePasse = motDePasse;
        this.age = age;
        if (idUser.equalsIgnoreCase("random")){
            this.idUser = "K"+prenom.substring(0)+nom.substring(0);
            for(int i=0; i<4;i++){
                Random r = new Random();
                int chiffre = r.nextInt(4);
                this.idUser += chiffre;
            }
        }
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
