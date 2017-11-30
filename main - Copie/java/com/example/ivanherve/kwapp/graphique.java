package com.example.ivanherve.kwapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by Ivan HERVE on 15-11-17.
 */

public class graphique extends AppCompatActivity {
    private LineGraphSeries<DataPoint> series1;

    public LineGraphSeries<DataPoint> getSeries1() {
        return series1;
    }



    /*
     * méthode qui dessine un graphique linéaire
     */
    protected void fonctGraph1(){
        double x,y;
        x = -5.0;

        GraphView graph = (GraphView) findViewById(R.id.graph1);
        series1 = new LineGraphSeries<DataPoint>();

        Viewport viewport = graph.getViewport();
        viewport.setYAxisBoundsManual(true);
        viewport.setMaxY(10);
        viewport.setScrollable(true);

        int [] histogram = {5,2,1,7,3,6,4,9,8};
        if (histogram.length <= 1)   return;
        DataPoint[] data=new DataPoint[histogram.length];
        for (int i=0; i < histogram.length; i++)   data[i]=new DataPoint(i,histogram[i]);
        LineGraphSeries<DataPoint> series=new LineGraphSeries<>(data);
        graph.addSeries(series);
        LegendRenderer lg = new LegendRenderer(graph);
    }

    /*
     * méthode qui affiche un histogramme
     */
    protected void fonctGraph2(){
        GraphView graph = (GraphView) findViewById(R.id.graph2);

        graph.removeAllSeries();
        Viewport viewport=graph.getViewport();
        viewport.setScrollable(true);

        viewport.setMaxX(9);
        int [] histogram = {5,2,1,7,3,6,4,9,8};
        if (histogram.length <= 1)   return;
        DataPoint[] data=new DataPoint[histogram.length];
        for (int i=0; i < histogram.length; i++)   data[i]=new DataPoint(i,histogram[i]);
        BarGraphSeries<DataPoint> series=new BarGraphSeries<>(data);
        series.setSpacing(50);
        graph.addSeries(series);
    }

    public void createBarGraph(String Date1, String Date2){/*
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date1 = simpleDateFormat.parse(Date1);
            Date date2 = simpleDateFormat.parse(Date2);

            Calendar mDate1 = Calendar.getInstance();
            Calendar mDate2 = Calendar.getInstance();
            mDate1.clear();
            mDate2.clear();

            mDate1.setTime(date1);
            mDate2.setTime(date2);

            dates = new ArrayList<>();
            dates = getList(mDate1,mDate2);

            barEntries = new ArrayList<>();
            float max = 0f;
            float value = 0f;
            random = new Random();
            for(int j = 0; j< dates.size();j++){
                max = 100f;
                value = random.nextFloat()*max;
                barEntries.add(new BarEntry(value,j));
            }
        } catch (ParseException e){
            e.printStackTrace();
        }
   */ }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphique);

        fonctGraph1();
        fonctGraph2();
    }

    public ArrayList<String> getList(Calendar startDate, Calendar endDate){
        ArrayList<String> list = new ArrayList<String>();
        while(startDate.compareTo(endDate)<=0){
            list.add(getDate(startDate));
            startDate.add(Calendar.DAY_OF_MONTH,1);
        }
        return list;
    }

    public String getDate(Calendar cld){
        String curDate = cld.get(Calendar.YEAR) + "/" + (cld.get(Calendar.MONTH) + 1) + "/"
                +cld.get(Calendar.DAY_OF_MONTH);
        try{
            Date date = new SimpleDateFormat("yyyy/MM/dd").parse(curDate);
            curDate =  new SimpleDateFormat("yyy/MM/dd").format(date);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return curDate;
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
