package com.example.ivanherve.kwapp;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

/**
 * Created by Ivan HERVE on 15-11-17.
 */

public class resultats extends AppCompatActivity {

    private double []result = {2043.0,2465.0,2222.0,1342.0};

    public double getResultOnIndex(int indice)
    {
        return result[indice];
    }

    public double getAvg(){
        double sum = 0, avg;
        for (int i=0;i<result.length;i++){
            sum += result[i];
        }
        avg = sum/result.length;
        return avg;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultats);

        TextView textViewValeur1 = (TextView) findViewById(R.id.textViewValeur1);
        textViewValeur1.setText(String.valueOf(getResultOnIndex(0))+" kWh");

        TextView textViewValeur2 = (TextView) findViewById(R.id.textViewValeur2);
        textViewValeur2.setText(String.valueOf(getAvg()+" kWh"));
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

/*   public static void main(String []args){
        System.out.println(getAvg());
    }*/
}
