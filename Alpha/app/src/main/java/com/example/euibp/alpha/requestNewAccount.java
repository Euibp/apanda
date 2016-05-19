package com.example.euibp.alpha;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.consent.GetConsentIntentRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by euibp on 18/05/2016.
 */
public class requestNewAccount extends AsyncTask<String,Void,String> {

    private TextView erroText;
    private Context context;
    //Editar para ser uma apresentação de uma tela de confirmação

    public requestNewAccount(Context context, TextView erroText) {
        this.context = context;
        this.erroText = erroText;

    }

    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... arg0) {

        String enderecoEmail = arg0[0];
        String password = arg0[1];
        String link = "http://vamosnosajudar.890m.com/Hackathon/CriarConta.php";
        //      String link = "http://php.net/manual/pt_BR/reserved.variables.post.php";
        try {
            String data = URLEncoder.encode("enderecoEmail", "UTF-8") + "=" + URLEncoder.encode(enderecoEmail, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
            BufferedReader reader = requestLogin.openPHP(link, data);


            String in = reader.readLine();
            Log.d("Alpha", in);
            if (in == null) {
                return ("erroDeLogin");
            }

            return (in);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String confirm) {
        //Problema de Senha
        if(confirm ==null || Float.parseFloat(confirm)<0){
            this.erroText.setText("Login Inválido");
        }else{
            Intent intent = new Intent(context, RequestSearch.class);
            context.startActivity(intent);
          }
    }




}
