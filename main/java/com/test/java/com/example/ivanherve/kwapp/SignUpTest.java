package com.example.ivanherve.kwapp;

import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.ivanherve.kwapp.R.id.age;
import static java.lang.Integer.parseInt;
import static org.junit.Assert.*;

/**
 * Created by Ivan HERVE on 21-11-17.
 */
public class SignUpTest extends AppCompatActivity{

    private String url = "jdbc:mysql://51.255.167.206/Kwapp_Projet?verifyServerCertificate=false&useSSL=false";
    private String userSql = "kwapp";
    private String passwordSql = "P@ssw0rd";

    @Test
    public void injectionData() throws Exception {/*
        EditText fieldNom = (EditText) findViewById(R.id.nom);
        String nom = fieldNom.getText().toString();
        EditText fieldPrenom = (EditText) findViewById(R.id.prenom);
        String prenom = fieldPrenom.getText().toString();
        EditText fieldPseudo = (EditText) findViewById(R.id.pseudo);
        String pseudo = fieldPseudo.getText().toString();
        EditText fieldEmail = (EditText) findViewById(R.id.email);
        String email = fieldEmail.getText().toString();
        EditText fieldMdp = (EditText) findViewById(R.id.password);
        String motDePasse = fieldMdp.getText().toString();
        EditText fieldAge = (EditText) findViewById(age);
        String ageTxt = fieldAge.getText().toString();
        int age = parseInt(ageTxt);

        Utilisateur user = new Utilisateur("random",nom,prenom,pseudo,email,motDePasse,age);*/

        try {
            Connection connect = DriverManager.getConnection(url,userSql,passwordSql);
            Statement st = connect.createStatement();
            st.executeUpdate("INSERT INTO Kwapp_Projet.User VALUES (4,'Studio','Android','lala','lala@tamere.be','azerty',32);");
        } catch (SQLException e) {
            System.out.println("Oups! :( : "+ e.getMessage());
        }
    }



}