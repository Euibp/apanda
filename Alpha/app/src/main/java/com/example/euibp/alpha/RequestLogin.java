package com.example.euibp.alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by euibp on 18/05/2016.
 */
public class requestLogin extends AsyncTask<String,Void,String>{

    private TextView erroText;
    private Context context;
    //Editar para ser uma apresentação de uma tela de confirmação

    public requestLogin(Context context,TextView erroText) {
        this.context = context;
        this.erroText = erroText;

    }
    protected void onPreExecute(){

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
            BufferedReader reader = openPHP(link, data);


          String in = reader.readLine();
            Log.d("Alpha",in);
           if (in==null) {
               return ("erroDeLogin");
            }

            return(in);
        } catch (Exception e) {
            return new String("Exception: " + e.getMessage());
       }
    }

    @Override
    protected void onPostExecute(String confirm){
       this.erroText.setText("Login Válido");
    }

    public static BufferedReader openPHP(String link,String data) throws Exception{

           URL url = new URL(link);
           URLConnection conn = url.openConnection();
           conn.setDoOutput(true);
           OutputStreamWriter wire = new OutputStreamWriter(conn.getOutputStream());
           wire.write(data);
           wire.flush();
           wire.close();

           return (new BufferedReader(new InputStreamReader(conn.getInputStream())));


    }
}
