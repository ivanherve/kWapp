package com.example.ivanherve.myapplication;

import android.annotation.SuppressLint;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.jjoe64.graphview.*;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


/**
 * Created by Ivan HERVE on 19-10-17.
 * cfr. https://www.youtube.com/watch?v=VriiDn676PQ to see how to draw graphics with android studio
 */

public class graphique extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series1;
    private Button button_calcul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graphique);

        double x,y;
        x = -5.0;

        GraphView graph = (GraphView) findViewById(R.id.graph1);
        series1 = new LineGraphSeries<DataPoint>();

        Viewport viewport = graph.getViewport();
        viewport.setYAxisBoundsManual(true);
        viewport.setMinY(0);
        viewport.setMaxY(10);
        viewport.setScrollable(true);

        int numDataPoints = 500;
        for (int i = 0;i<numDataPoints;i++){
            x = x + 0.5;
            y = 2.5*x;
            series1.appendData(new DataPoint(x,y),true,numDataPoints);
        }
        graph.addSeries(series1);
    }
}
