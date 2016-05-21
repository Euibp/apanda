package com.example.euibp.alpha;

/**
 * Created by euibp on 21/05/2016.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class JoinConfirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinconfirm);
    }

/*    public void Tutorial(View view){
        Intent intent = new Intent(this, Tutorial.class);
        startActivity(intent);
    }
*/
    public void login (View view){
        Intent loginIntent = new Intent(this,aPandaMain.class);
        startActivity(loginIntent);
    }
}