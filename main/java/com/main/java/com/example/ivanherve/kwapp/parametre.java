package com.example.ivanherve.kwapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

/**
 * Created by Ivan HERVE on 16-11-17.
 */

public class parametre extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parametre);
    }

    //---------Méthodes onClick des quatres différents bouttons-----------------------

    public void onClickResultats (View view){// setContentView(R.layout.resultats);
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
}
