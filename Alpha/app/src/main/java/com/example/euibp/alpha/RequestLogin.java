package com.example.euibp.alpha;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by euibp on 18/05/2016.
 */
public class RequestLogin extends AsyncTask<String,Void,String>{

    private TextView statusField,roleField;
    private Context context;
    private int getOrpost = 0;

    public RequestLogin(Context context,TextView statusField,TextView roleField,int flag) {
        this.context = context;
        this.statusField = statusField;
        this.roleField = roleField;
        getOrpost = flag;
    }
    protected void onPreExecute(){

    }
    @Override
    protected String
}
