package com.example.withuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;

import com.example.withuapp.model.Psicologo;
import com.example.withuapp.model.Usuario;

public class Inicio extends AppCompatActivity {

    private Button programarBtn;
    private Button citasBtn;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        citasBtn=findViewById(R.id.citasBtn);
        programarBtn=findViewById(R.id.programarBtn);
        Usuario user=(Usuario) getIntent().getExtras().getSerializable("usuarioActual");

        programarBtn.setOnTouchListener(
                (v,event)->{
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            v.setBackgroundResource(R.drawable.pressed_button);
                            break;

                        case MotionEvent.ACTION_UP:
                            v.setBackgroundResource(R.drawable.rounded_button);
                            Intent in=new Intent(Inicio.this,Psicologos.class);
                            in.putExtra("usuarioActual", user);
                            startActivity(in);
                            break;
                    }
                    return true;
                }
        );

        citasBtn.setOnTouchListener(
                (v,event)->{
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            v.setBackgroundResource(R.drawable.pressed_button);
                            break;

                        case MotionEvent.ACTION_UP:
                            v.setBackgroundResource(R.drawable.rounded_button);
                            Intent in=new Intent(Inicio.this,Citas.class);
                            startActivity(in);
                            break;
                    }
                    return true;
                }
        );

    }
}
