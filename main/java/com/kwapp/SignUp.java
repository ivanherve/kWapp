package com.example.ivanherve.kwapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.Integer.parseInt;

/**
 * Created by Ivan HERVE on 17-11-17.
 */

public class SignUp extends AppCompatActivity {

    private String nom;
    private String prenom;
    private String pseudo;
    private String email;
    private String motDePasse;
    private int age;
    private Statement statement;
    private String url = "jdbc:mysql://51.255.167.206/Kwapp_Projet?verifyServerCertificate=false&useSSL=false";
    private String userSql = "kwapp";
    private String passwordSql = "P@ssw0rd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
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


    public void onClickInscription (View view){/**/
        //d'abord injecter les données avant d'acceder à la page d'accueil
        injectionData();

        //Ensuite connecter le nouvel utilisateur
        String msg = "";
        Utilisateur user = new Utilisateur("random",nom,prenom,pseudo,email,motDePasse,age);
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");

            Connection connect = DriverManager.getConnection(url,userSql,passwordSql);

            if (connect == null) {
                msg = "Verifiez si vous avez acces à Internet";
            } else {
                // Change below query according to your own database.
                String query = "select * from Kwapp_Projet.User where Email= '" + user.getEmail() + "' and Mot_de_passe = '" + user.getMotDePasse() + "';  ";
                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()) {
                    // msg = "Login successful";
                    Intent mainActivite = new Intent(this, MainActivity.class);
                    startActivity(mainActivite);
                    connect.close();
                } else {
                    msg = "Connexion impossible :( \nSoit votre adresse email, soit votre mot de passe est incorrect !";
                }
            }
        } catch (Exception e){
            msg = e.getMessage();
        }
        TextView textErr = (TextView) findViewById(R.id.erreur);
        textErr.setText(msg);

        // Accede au MainActivity une fois connecté
        Intent mainActivite = new Intent(this, MainActivity.class);
        startActivity(mainActivite);
    }

    public void injectionData(){
        EditText fieldNom = (EditText) findViewById(R.id.nom);
        nom = fieldNom.getText().toString();
        EditText fieldPrenom = (EditText) findViewById(R.id.prenom);
        prenom = fieldPrenom.getText().toString();
        EditText fieldPseudo = (EditText) findViewById(R.id.pseudo);
        pseudo = fieldPseudo.getText().toString();
        EditText fieldEmail = (EditText) findViewById(R.id.email);
        email = fieldEmail.getText().toString();
        EditText fieldMdp = (EditText) findViewById(R.id.password);
        motDePasse = fieldMdp.getText().toString();
        EditText fieldAge = (EditText) findViewById(R.id.age);
        String ageTxt = fieldAge.getText().toString();
        age = parseInt(ageTxt);
        Utilisateur user = new Utilisateur("random",nom,prenom,pseudo,email,motDePasse,age);
        try {
            Connection connect = DriverManager.getConnection(url,userSql,passwordSql);
            Statement st = connect.createStatement();
            st.executeUpdate("INSERT INTO Kwapp_Projet.User VALUES ('"+user.getIdUser()+"','"+user.getNom()+"','"+user.getPrenom()+"','"+user.getPseudo()+"','"+user.getEmail()+"','"+user.getMotDePasse()+"',"+user.getAge()+");");
        } catch (SQLException e) {
            TextView textErr = (TextView) findViewById(R.id.erreur);
            textErr.setText("Inscription impossible :(");
            e.printStackTrace();
        }
    }
}
