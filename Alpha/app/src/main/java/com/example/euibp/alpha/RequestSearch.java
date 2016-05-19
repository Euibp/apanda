package com.example.euibp.alpha;


import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.net.URLEncoder;


/**
 * Created by euibp on 18/05/2016.
 */
public class RequestSearch extends AppCompatActivity {

    String [] centros = new String[]{"Cidade Universitária","Praia Vermelha","Xérem","Macaé","Ifics","Esfa","Escola de Enfermagem Ana Nery","Escola de Musica","Escola de Direito","Observatório do Valongo"};
    String centrosText;
    TextView erroText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        Spinner spinner = (Spinner) findViewById(R.id.Centros);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Centros, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                centrosText = centros[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        erroText = (TextView)findViewById(R.id.erroText);

        Intent intent = getIntent();
        if (intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
           /* sqlSearch(query, centrosText);*/
            new rrSearch(this,erroText).execute(query,centrosText);
        }
    }

  /*  private void sqlSearch(String query,String centrosText) {
        String link = "http://vamosnosajudar.890m.com/Hackathon/ProcurarBancoDados.php";
        try {
            String data = URLEncoder.encode("Centros", "UTF-8") + "=" + URLEncoder.encode(centrosText, "UTF-8");
            data += "&" + URLEncoder.encode("query", "UTF-8") + "=" + URLEncoder.encode(query, "UTF-8");

            BufferedReader in = requestLogin.openPHP(link, data);


        }
        catch(Exception e) {
        }
    }*/
}




