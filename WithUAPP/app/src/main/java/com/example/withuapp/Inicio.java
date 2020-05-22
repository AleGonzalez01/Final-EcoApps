package com.example.withuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Inicio extends AppCompatActivity {

    private Button programarBtn;
    private Button citasBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        citasBtn=findViewById(R.id.citasBtn);
        programarBtn=findViewById(R.id.programarBtn);

        programarBtn.setOnClickListener(
                (v)->{
                    Intent in=new Intent(this,Psicologos.class);
                    startActivity(in);
                }
        );
    }
}
