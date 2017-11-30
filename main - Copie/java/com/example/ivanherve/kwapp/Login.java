package com.example.ivanherve.kwapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Ivan HERVE on 17-11-17.
 */

public class Login extends AppCompatActivity{
    private String email;
    private String password;
    private Utilisateur user;
    private String [][] listeUsers;
    private String userSql = "kwapp";
    private String passwordSql = "P@ssw0rd";
    private String url = "jdbc:mysql://51.255.167.206/Kwapp_Projet?verifyServerCertificate=false&useSSL=false&autoReconnect=true";
    private static Connection connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

    }
    public String getEmail() {
        EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        email = editTextEmail.getText().toString();
        return email;
    }

    public String getPassword() {
        EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        password = editTextPassword.getText().toString();
        return password;
    }

    public void onClickConnexion (View view){/*
        getEmail();
        getPassword();
//
        //Indique un message d'erreur au cas où
        String msg = "";

        if (getEmail() == "" || getPassword() == ""){
            msg = "Les champs sont vides! \nVeuillez entrer votre adresse email et votre mot de passe svp";
        } else {
            try {
               // StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
               // StrictMode.setThreadPolicy(policy);


                Class.forName("com.mysql.jdbc.Driver");
                connect =  DriverManager.getConnection(url,userSql,passwordSql);

                if (connect == null) {
                    msg = "Verifiez si vous avez acces à Internet";
                } else {
                    // Change below query according to your own database.
                    String query = "select * from Kwapp_Projet.User where Email= '" + getEmail() + "' and Mot_de_passe = '" + getPassword() + "'  ";
                    Statement stmt = connect.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    if (rs.next()) {
                       // msg = "Login successful";
                        user.setEmail(email);
                        user.setMotDePasse(password);

                        Intent mainActivite = new Intent(this, MainActivity.class);
                        startActivity(mainActivite);
                        connect.close();
                    } else {
                        msg = "Connexion impossible :( \nSoit votre adresse email, soit votre mot de passe est incorrect !";
                    }
                }
            } catch (Exception e){
                msg = "Internet accesible mais \n"+e.getMessage();
                e.printStackTrace();
            }
            TextView textErr = (TextView) findViewById(R.id.erreur);
            textErr.setText(msg);
        }*/
        Intent mainActivite = new Intent(this, MainActivity.class);
        startActivity(mainActivite);
    }

    public void onClickSignUp (View view){
        SignUp su = new SignUp();
        Intent inscription = new Intent(this, su.getClass());
        startActivity(inscription);
    }

    public void onClickPasswordForgot (View view){
        // A compléter
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.button_Parametre){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
