package com.example.onlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Terminos extends AppCompatActivity {

    private TextView titulo, info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos);

        titulo = (TextView) findViewById(R.id.titulo);
        info = (TextView) findViewById(R.id.info);
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, Sign_Up.class);
        startActivity(intent);
        finish();
    }
}