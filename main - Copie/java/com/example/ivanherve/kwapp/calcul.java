package com.example.ivanherve.kwapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Ivan HERVE on 16-11-17.
 */

public class calcul extends AppCompatActivity {
    Spinner spinner;
    // ArrayAdapter<CharSequence> adapter;
    EditText tp;
    EditText tp2;
    EditText tp3;
    EditText tp4;
    EditText tp5;
    EditText tp6;
    EditText tp7;
    EditText tp8;
    EditText tp9;
    EditText tp10;
    int resultat;
    int prix;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcul);
        TextView buttonCalcul = (TextView)findViewById(R.id.button2);
        buttonCalcul.setText(Html.fromHtml("<u>CALCUL</u>"));
    }

    public void onClick(View view) {
        final EditText tp1;
        tp1 = (EditText) findViewById(R.id.editText1a);
        String tp1_1 = tp1.getText().toString();
        int a =Integer.parseInt(tp1_1);
        resultat = a * 2;
        prix = resultat * 1;
        TextView textResultat = (TextView) findViewById(R.id.resultatview);
        textResultat.setText(" => "+Html.fromHtml("<u>"+Integer.toString(resultat)+"</u>")+" kWh");
        TextView textPrix = (TextView) findViewById(R.id.resultatprix);
        textPrix.setText(" => "+Html.fromHtml("<u>"+Integer.toString(prix)+"</u>")+" €");

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
