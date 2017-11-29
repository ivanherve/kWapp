package com.example.ivanherve.kwapp;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.*;

/**
 * Created by Ivan HERVE on 21-11-17.
 */
public class LoginTest extends AppCompatActivity {

    private String userSql = "kwapp";
    private String passwordSql = "P@ssw0rd";
    private String url = "jdbc:mysql://51.255.167.206:3306/Kwapp_Projet?verifyServerCertificate=false&useSSL=false";

    @Test
    public void onClickSignUp() throws Exception {
        Intent inscription = new Intent(this, SignUp.class);
        startActivity(inscription);
    }

    @Test
    public void test(){
        Login log1 = new Login();

        Intent inscription = new Intent(log1, SignUp.class);
        assertNotNull(inscription);/*
        try {
            assertNull(inscription);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        */
    }
    String email = "'admin@admin.com'";
    String motdepasse = "'admin'";

    //Indique un message d'erreur au cas où
    String msg = "msg";
    @Test
    public void onClickConnexion (){

        if (email == "" && motdepasse == ""){
            msg = "Les champs sont vides! \nVeuillez entrer votre adresse email et votre mot de passe svp";
        } else {
            try {/*
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);*/
                Class.forName("com.mysql.jdbc.Driver");
                Connection connect =  DriverManager.getConnection(url,userSql,passwordSql);

                if (connect == null) {
                    msg = "Verifiez si vous avez acces à Internet";
                } else {
                    // Change below query according to your own database.
                    String query = "select * from Kwapp_Projet.User where Email= "+email+" and Mot_de_passe = "+motdepasse+" ;";
                    Statement stmt = connect.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        msg = "Login successful";
                        String lastName = rs.getString("Email");
                        System.out.print(" "+lastName+" ");
                        String motdepasse1 = rs.getString("Mot_de_passe");
                        System.out.print(" "+motdepasse1+" ");
                    } else if (rs.next() == false){
                        msg = "Connexion impossible :( \nSoit votre adresse email, soit votre mot de passe est incorrect !";
                    }
                    System.out.println(msg);
                }
            } catch (Exception e){
                msg = e.getMessage();
            }
        }
        System.out.print(msg);
    }
}