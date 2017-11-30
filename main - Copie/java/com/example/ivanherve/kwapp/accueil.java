package com.example.ivanherve.kwapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.wang.avi.*;

/**
 * Created by Ivan HERVE on 22-11-17.
 */

public class accueil extends AppCompatActivity {
    AVLoadingIndicatorView avi;

    View accueil = (View) findViewById(R.id.accueil);

    Handler mHandler=new Handler();
    final Runnable mRunnable = new Runnable() {
        @Override
        public void run(){
            // TODO Auto-generated method stub
            accueil.setVisibility(View.GONE); //This will remove the View. and free s the space occupied by the View
        }
    };
/*
    private View.OnTouchListener mVolPlusOnTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            accueil.setVisibility(View.VISIBLE);
            mHandler.removeCallbacks(mRunnable);
            mHandler.postDelayed(mRunnable, 10000);
        }
    };
*/
    private void HideLayout(){
        accueil.postDelayed(mRunnable, 1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
/*
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Intent loginActivity = new Intent(this, Login.class);
        startActivity(loginActivity);

       // mHandler.postDelayed(mRunnable,10*1000);

        long futureTime = System.currentTimeMillis() + 5000;
        while(System.currentTimeMillis() < futureTime){
            synchronized (this){
                try{
                    wait(futureTime-System.currentTimeMillis());
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        }
        Intent loginActivity = new Intent(this, Login.class);
        startActivity(loginActivity);*/
    }

    /*
    @Override
    protected void onPreExecute(){
        progressDialog.setMessage("Chargement ...");
        progressDialog.show();
    }
    */

    void startAnim(){
        avi.show();
        // or avi.smoothToShow();
    }

    void stopAnim(){
        avi.hide();
        // or avi.smoothToHide();
    }
}
