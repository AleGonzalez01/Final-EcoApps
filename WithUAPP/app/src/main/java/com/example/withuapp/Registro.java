package com.example.withuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.withuapp.model.Usuario;
import com.google.firebase.database.FirebaseDatabase;

public class Registro extends AppCompatActivity {
    private EditText nombreET;
    private EditText emailET;
    private EditText passwordET;
    private EditText passwordET2;
    private Button signupBtn;
    private String contra;
    private String confirmar;

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
                            String id= FirebaseDatabase.getInstance().getReference().child("Usuarios").push().getKey();
                            String nombre=nombreET.getText().toString();
                            String correo=emailET.getText().toString();
                            contra=passwordET.getText().toString();
                            confirmar=passwordET2.getText().toString();

                            Usuario usuario=new Usuario(id,nombre,correo,contra);
                            if(contra.equals(confirmar)){
                                FirebaseDatabase.getInstance().getReference().child("Usuarios").child(id).setValue(usuario);
                            }

                            break;

                        case MotionEvent.ACTION_UP:
                            v.setBackgroundResource(R.drawable.rounded_button);
                            if(contra.equals(confirmar)){
                                Intent in=new Intent(this,InicioSesion.class);
                                startActivity(in);
                            }else{
                                Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_LONG).show();
                            }
                            break;
                    }
                    return true;
                }
        );
    }
}
