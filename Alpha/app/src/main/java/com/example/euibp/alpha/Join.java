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

        //int eRRo = functionErro();

        switch(functionErro()){
            case 0 :
                String username = usernameField.getText().toString();
                String password = passwordField.getText().toString();
                new requestNewAccount(this, erroText).execute(username, password);
                break;
            case 1 :
                erroText.setText("Email Inválido");
                break;
            case 2 :
                erroText.setText("Senha Inválida");
                break;
            case 3 :
                erroText.setText("Confirmação de Senha Inexistente");
                break;
            case 4 :
                erroText.setText("Voce é um animal que não consegue colocar a mesma senha duas vezes");
                break;
            default:
                erroText.setText("Erro Desconhecido");
                break;
        }
        /*if(confirmField.getText().toString().equals(passwordField.getText().toString())) {
            String username = usernameField.getText().toString();
            String password = passwordField.getText().toString();
            new requestNewAccount(this, erroText).execute(username, password);
        }else{
            erroText.setText("Voce é um animal que não consegue colocar a mesma senha duas vezes");
        }*/
    }

    public int functionErro(){
        if(usernameField.getText().toString().equals("")){
            return(1); }
        if(passwordField.getText().toString().equals("")){
            return(2);
        }
        if(confirmField.getText().toString().equals("")) {
            return(3);
        }
        if (confirmField.getText().toString().equals(passwordField.getText().toString())) {
            return(0);
        }
        return(4);
    }

        public void returnMain(View view){
            Intent intent = new Intent(this, Main.class);
            startActivity(intent);
        }

    }

