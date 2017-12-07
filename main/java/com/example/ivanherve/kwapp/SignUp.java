package com.example.ivanherve.kwapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Statement;

import static java.lang.Integer.parseInt;

/**
 * Created by Ivan HERVE on 17-11-17.
 */

public class SignUp extends AppCompatActivity {

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
    EditText fieldAge = (EditText) findViewById(R.id.age);
    String ageTxt = fieldAge.getText().toString();
    int age = parseInt(ageTxt);

    Utilisateur user = new Utilisateur("random",nom,prenom,pseudo,email,motDePasse,age);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        user.setNom(nom);
        user.setPrenom(prenom);
        user.setPseudo(pseudo);
        user.setEmail(email);
        user.setMotDePasse(motDePasse);
        user.setAge(age);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPseudo() { return pseudo; }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public int getAge() {
        return age;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void onClickInscription (View view){
        //Injecter les données dans bdd
        injectionData();
        // Accede au MainActivity une fois connecté
        Intent mainActivite = new Intent(this, MainActivity.class);
        startActivity(mainActivite);
    }

    public void injectionData(){
        String type = "subscribe";
        try {
            BackgroundWorkerSignUp bGWSU = new BackgroundWorkerSignUp(this);
            bGWSU.execute(type,pseudo,nom,prenom,email,ageTxt,motDePasse);
        } catch (Exception e) {
            TextView textErr = (TextView) findViewById(R.id.erreur);
            textErr.setText("Inscription impossible :(");
            e.printStackTrace();
        }
    }
}
