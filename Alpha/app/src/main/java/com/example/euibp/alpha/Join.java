package com.example.euibp.alpha;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;

public class Join extends AppCompatActivity {

    private EditText usernameField,passwordField,confirmField;
    private TextView erroText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join);

        usernameField = (EditText)findViewById(R.id.emailText);
        passwordField = (EditText)findViewById(R.id.passText);
        confirmField = (EditText)findViewById(R.id.confirmText);
        erroText = (TextView)findViewById(R.id.erroText);
    }


    public void register(View view){

        if(confirmField.getText().toString().equals(passwordField.getText().toString())) {
            String username = usernameField.getText().toString();
            String password = passwordField.getText().toString();
            new requestLogin(this, erroText).execute(username, password);
        }else{
            erroText.setText("Voce é um animal que não consegue colocar a mesma senha duas vezes");
        }
    }

    public void returnMain(View view){
        Intent intent = new Intent(this, Main.class);
        // EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
        // intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}

