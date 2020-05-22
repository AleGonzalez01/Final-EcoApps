package com.example.withuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.withuapp.model.Usuario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

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
                            Query busqueda= FirebaseDatabase.getInstance().getReference().child("Usuarios")
                                    .orderByChild("correo").equalTo(correoET.getText().toString());
                            busqueda.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    for(DataSnapshot coincidencia: dataSnapshot.getChildren()){
                                        Usuario usuarioEncontrado=coincidencia.getValue(Usuario.class);
                                        if(usuarioEncontrado.getContrasena().equals(contraET.getText().toString())){
                                            Intent in=new Intent(InicioSesion.this,Inicio.class);
                                            startActivity(in);
                                        }else{
                                            Toast.makeText(InicioSesion.this,"La contraseña está equivocada",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            v.setBackgroundResource(R.drawable.rounded_button);

                            break;
                    }
                    return true;
                }
        );
    }
}
