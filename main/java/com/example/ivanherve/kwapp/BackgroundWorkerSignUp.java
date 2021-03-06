package com.example.ivanherve.kwapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Ivan HERVE on 05-12-17.
 */

public class BackgroundWorkerSignUp extends AsyncTask<String,Void,String> {
    //-------------------------------------------BACKGROUNDWORKER.JAVA--------------------------------------------------------------------

    Login login;
    Context context;
    AlertDialog alertDialog;
    BackgroundWorkerSignUp(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://51.255.167.206/connect/subscribe.php";
        if (type.equals("subscribe")){
            try {
                String pseudo = params[1];
                String nom = params[2];
                String prenom = params[3];
                String email = params[4];
                String age = params[5];
                String password = params[6];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("pseudo","UTF-8")+"="+URLEncoder.encode(pseudo,"UTF-8")+"&"
                        +URLEncoder.encode("nom","UTF-8")+"="+ URLEncoder.encode(nom,"UTF-8")+"&"
                        +URLEncoder.encode("prenom","UTF-8")+"="+ URLEncoder.encode(prenom,"UTF-8")+"&"
                        +URLEncoder.encode("email","UTF-8")+"="+ URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("age","UTF-8")+"="+ URLEncoder.encode(age,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+ URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Etat de Connexion");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        if (result.equals("ERROR - Mot de passe et/ou login incorrect...")){
            alertDialog.show();
        } else {
            Intent activity = new Intent(context, MainActivity.class);
            context.startActivity(activity);
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    //--------------------------------------------BACKGROUNDWORKER.JAVA--------------------------------------------------------------------


}
