package com.example.euibp.alpha;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.net.URLEncoder;

/**
 * Created by euibp on 18/05/2016.
 */
public class rrSearch extends AsyncTask<String,Void,String> {

    private TextView erroText;
    private Context context;
    //Editar para ser uma apresentação de uma tela de confirmação

    public rrSearch(Context context, TextView erroText) {
        this.context = context;
        this.erroText = erroText;

    }

    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(String... arg0) {

        String query = arg0[0];
        String centros = arg0[1];
        String link = "http://vamosnosajudar.890m.com/Hackathon/ProcurarBancoDados.php";
        //      String link = "http://php.net/manual/pt_BR/reserved.variables.post.php";
        try {
            String data = URLEncoder.encode("seletor", "UTF-8") + "=" + URLEncoder.encode(query, "UTF-8");
            data += "&" + URLEncoder.encode("conteudoSeletor", "UTF-8") + "=" + URLEncoder.encode(centros, "UTF-8");
            BufferedReader reader = requestLogin.openPHP(link, data);

            //Reconstruir
            String in = reader.readLine();
           //while(in != null);
            Log.d("Alpha", in);
            if (in == null) {
                return ("erroDeLogin");
            }
            return (in);
            //Reconstruir
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(String confirm) {
        if(confirm ==null || Float.parseFloat(confirm)<0){
            this.erroText.setText("Arquivo Inválido");
          }
    }




}
