package com.example.withuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;

public class InicioSesion extends AppCompatActivity {
    private EditText correoET;
    private EditText contraET;
    private Button inicioBtn;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        correoET=findViewById(R.id.correoET);
        contraET=findViewById(R.id.contraET);
        inicioBtn=findViewById(R.id.inicioBtn);

        inicioBtn.setOnTouchListener(
                (v,event)->{
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            v.setBackgroundResource(R.drawable.pressed_button);
                            break;

                        case MotionEvent.ACTION_UP:
                            v.setBackgroundResource(R.drawable.rounded_button);
                            Intent in=new Intent(this,Inicio.class);
                            startActivity(in);
                            break;
                    }
                    return true;
                }
        );
    }
}
