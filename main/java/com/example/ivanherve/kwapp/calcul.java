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
    int resultat;
    double prix;
    static double resultat2;

    public double getResultat2() {
        return resultat2;
    }

    public void setResultat2(double resultat2) {
        this.resultat2 = resultat2;
    }


    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcul);
        TextView buttonCalcul = (TextView)findViewById(R.id.button2);
        buttonCalcul.setText(Html.fromHtml("<u>CALCUL</u>"));

        spinner = (Spinner)findViewById(R.id.spinnerapp);
    }

    public void onClick(View view) {
        final EditText tp1;
        final EditText tp2;
        final EditText tp3;
        final EditText tp4;
        final EditText tp5;
        final EditText tp6;
        final  EditText tp7;
        final  EditText tp8;
        final  EditText tp9;
        final  EditText tp10;

        double prixkw= (double) 0.027;

        tp1 = (EditText) findViewById(R.id.editText1a);
        tp2 = (EditText) findViewById(R.id.editText1b);
        tp3 = (EditText) findViewById(R.id.editText2a);
        tp4 = (EditText) findViewById(R.id.editText2b);
        tp5 = (EditText) findViewById(R.id.editText3a);
        tp6 = (EditText) findViewById(R.id.editText3b);
        tp7 = (EditText) findViewById(R.id.editText4a);
        tp8 = (EditText) findViewById(R.id.editText4b);
        tp9 = (EditText) findViewById(R.id.editText5a);
        tp10 = (EditText) findViewById(R.id.editText5b);

        String tp1_1 = tp1.getText().toString();
        String tp2_1 = tp2.getText().toString();
        String tp3_1 = tp3.getText().toString();
        String tp4_1 = tp4.getText().toString();
        String tp5_1 = tp5.getText().toString();
        String tp6_1 = tp6.getText().toString();
        String tp7_1 = tp7.getText().toString();
        String tp8_1 = tp8.getText().toString();
        String tp9_1 = tp9.getText().toString();
        String tp10_1 = tp10.getText().toString();

        int a =Integer.parseInt(String.valueOf(tp1_1));
        int b =Integer.parseInt(String.valueOf(tp2_1));
        int c =Integer.parseInt(String.valueOf(tp3_1));
        int d =Integer.parseInt(String.valueOf(tp4_1));
        int e =Integer.parseInt(String.valueOf(tp5_1));
        int f =Integer.parseInt(String.valueOf(tp6_1));
        int g =Integer.parseInt(String.valueOf(tp7_1));
        int h =Integer.parseInt(String.valueOf(tp8_1));
        int i =Integer.parseInt(String.valueOf(tp9_1));
        int j =Integer.parseInt(String.valueOf(tp10_1));

        setResultat((a * b) + (c * d) + (e * f) + (g * h) + (i * j));
        setResultat2(Double.parseDouble(String.valueOf(resultat)));
        prix = (double) (resultat2 * 0.027);

        TextView textResultat = (TextView) findViewById(R.id.resultatview);
        textResultat.setText(" => "+Html.fromHtml("<u>"+resultat2+"</u>")+" kWh");
        TextView textPrix = (TextView) findViewById(R.id.resultatprix);
        textPrix.setText(" => "+Html.fromHtml("<u>"+prix+"</u>")+" €");

/*
        TextView textResultat = (TextView) findViewById(R.id.resultatview);
        textResultat.setText(Integer.toString(resultat));
        TextView textPrix = (TextView) findViewById(R.id.resultatprix);
        textResultat.setText(Integer.toString(prix));
*/
    }

    public void onClickAideCalcul(View view){
        TextView textView = (TextView) findViewById(R.id.helpCalcul);
        textView.setText("Cette fonctionnalité vous permet d'avoir un résultat de votre consommation et du prix selon VOS estimmations. " +
                "\nRentrez vos données et cilquez sur Calcul, vous verrez votre consommation global sur un mois et un prix estimé");
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
