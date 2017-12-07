package com.example.ivanherve.kwapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SignUp su;
    Login log;
    BackgroundWorker backgroundWorker = new BackgroundWorker(this);

    private Utilisateur user = new Utilisateur("random",su.getNom(),su.getPrenom(),su.getPseudo(),su.getEmail(),su.getMotDePasse(),su.getAge());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backgroundWorker.execute("login",log.getPseudo(),log.getPassword());
        TextView bienvenue = (TextView) findViewById(R.id.fullscreen_content);
        bienvenue.setText("Bienvenue \n"+user.getPrenom());
    }

    public void onClickResultats (View view){/* setContentView(R.layout.resultats);*/
        Intent resultatActivite = new Intent(this, resultats.class);
        startActivity(resultatActivite);
    }

    public void onClickParametre (View view){ //setContentView(R.layout.parametre);
        Intent parametreActivite = new Intent(this, parametre.class);
        startActivity(parametreActivite);
    }

    public void onClickGraphique (View view){//setContentView(R.layout.graphique);
        Intent graphiqueActivite = new Intent(this, graphique.class);
        startActivity(graphiqueActivite);
    }

    public void onClickCalcul (View view){//setContentView(R.layout.calcul);
        Intent calculActivite = new Intent(this, calcul.class);
        startActivity(calculActivite);
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
