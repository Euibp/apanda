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
import android.content.Intent;
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
        String link = "http://vamosnosajudar.890m.com/Hackathon/Login.php";
  //      String link = "http://php.net/manual/pt_BR/reserved.variables.post.php";
        try {
            String data = URLEncoder.encode("enderecoEmail", "UTF-8") + "=" + URLEncoder.encode(enderecoEmail, "UTF-8");
            data += "&" + URLEncoder.encode("senha", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
            BufferedReader reader = openPHP(link, data);

            StringBuffer sb = new StringBuffer("");
            Log.d("Alpha",sb.toString());
            String line="";

            while ((line = reader.readLine()) != null) {
                sb.append(line);
                Log.d("Alpha",sb.toString());
                break;
            }
            reader.close();
            Log.d("Alpha",sb.toString());
           if (sb.toString()==null) {
               return ("erroDeLogin");
            }
            return(sb.toString());
        } catch (Exception e) {
            return null;
       }
    }

    @Override
    protected void onPostExecute(String confirm) {
        Log.d("Alpha",confirm);
        if(confirm ==null || Float.parseFloat(confirm)<0){
            this.erroText.setText("Login Inválido");
        }else{
            Intent intent = new Intent(context, aPandaMain.class);
            context.startActivity(intent);
        }
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
