package com.example.withuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity {
    private EditText nombreET;
    private EditText emailET;
    private EditText passwordET;
    private EditText passwordET2;
    private Button signupBtn;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombreET=findViewById(R.id.nombreET);
        emailET=findViewById(R.id.emailET);
        passwordET=findViewById(R.id.passwordET);
        passwordET2=findViewById(R.id.passwordET2);
        signupBtn=findViewById(R.id.signupBtn);

        signupBtn.setOnTouchListener(
                (v,event)->{
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            v.setBackgroundResource(R.drawable.pressed_button);
                            break;

                        case MotionEvent.ACTION_UP:
                            v.setBackgroundResource(R.drawable.rounded_button);
                            Intent in=new Intent(this,InicioSesion.class);
                            startActivity(in);
                            break;
                    }
                    return true;
                }
        );
    }
}
