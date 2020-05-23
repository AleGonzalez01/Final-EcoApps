package com.example.withuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.withuapp.model.Cita;
import com.example.withuapp.model.Psicologo;
import com.example.withuapp.model.Usuario;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class Agendar extends AppCompatActivity {

    private TextView nombreDoc;
    private TextView hora;
    private Button agendarBtn;
    private Psicologo p;
    private int minHora;
    private int maxHora;
    private int randomHora;
    private int minMinuto;
    private int maxMinuto;
    private int randomMinuto;
    private Usuario user;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar);

        user=(Usuario) getIntent().getExtras().getSerializable("usuarioActual");

        nombreDoc=findViewById(R.id.nombreDoc);
        hora=findViewById(R.id.hora);
        agendarBtn=findViewById(R.id.agendarBtn);

        p=(Psicologo) getIntent().getExtras().getSerializable("psicologoNombre");
        nombreDoc.setText(p.toString());

        minHora = 6;
        maxHora = 18;
        randomHora = new Random().nextInt((maxHora - minHora) + 1) + minHora;

        minMinuto = 10;
        maxMinuto = 59;
        randomMinuto = new Random().nextInt((maxMinuto - minMinuto) + 1) + minMinuto;


        String tiempoAsignado=randomHora+":"+randomMinuto;
        hora.setText(tiempoAsignado);

        Toast.makeText(this, ""+user, Toast.LENGTH_SHORT).show();

        agendarBtn.setOnTouchListener(
                (v,event)->{
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            v.setBackgroundResource(R.drawable.pressed_button);
                            break;

                        case MotionEvent.ACTION_UP:
                            v.setBackgroundResource(R.drawable.rounded_button);

                            String id=FirebaseDatabase.getInstance().getReference().child("Usuarios").child(user.getId())
                                    .child("Citas").push().getKey();

                            Cita cita=new Cita(id,"28 de Mayo",tiempoAsignado,p.toString());

                            FirebaseDatabase.getInstance().getReference().child("Usuarios").child(user.getId())
                                    .child("Citas").child(id).setValue(cita);

                            Intent in=new Intent(Agendar.this, Citas.class);
                            startActivity(in);
                            break;
                    }
                    return true;
                }
        );
    }
}
