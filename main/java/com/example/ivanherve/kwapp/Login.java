package com.example.ivanherve.kwapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Ivan HERVE on 17-11-17.
 */

public class Login extends AppCompatActivity{
    private String pseudo;
    private String password;
    private Utilisateur user;
    private String [][] listeUsers;
    private String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
    /**/
    public String getPseudo() {
        EditText editTextPseudo = (EditText) findViewById(R.id.editTextPseudo);
        pseudo = editTextPseudo.getText().toString();
        return pseudo;
    }

    public String getPassword() {
        EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        password = editTextPassword.getText().toString();
        return password;
    }

    public void onClickConnexion (View view){

        //Indique un message d'erreur au cas où
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, getPseudo(), getPassword());

        user.setPseudo(getPseudo());
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
