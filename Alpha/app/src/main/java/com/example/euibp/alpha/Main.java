package com.example.euibp.alpha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;

public class Main extends AppCompatActivity {

    private EditText usernameField,passwordField;
    private TextView erroText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameField = (EditText)findViewById(R.id.MainText_Name);
        passwordField = (EditText)findViewById(R.id.MainText_Password);
        erroText = (TextView)findViewById(R.id.erroText);
    }


     public void login(View view){
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        new requestLogin(this,erroText).execute(username,password);
     }

    public void createAcovnt(View view){
        Intent intent = new Intent(this, Join.class);
       // EditText editText = (EditText) findViewById(R.id.edit_message);
        //String message = editText.getText().toString();
       // intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        Log.d ("Alpha", "Clicou");
    }

}


