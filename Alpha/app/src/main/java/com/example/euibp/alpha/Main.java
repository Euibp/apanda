package com.example.euibp.alpha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;


public class Main extends AppCompatActivity {

    private EditText usernameField,passwordField;
    private TextView status,role,method;

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Centros, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        public void login(View view){
            String username = usernameField.getText().toString();
            String password = passwordField.getText().toString();
            method.setText("Get Method");
            new RequestLogin(this,status,role,0).execute(username,password);

        }
    }
}

