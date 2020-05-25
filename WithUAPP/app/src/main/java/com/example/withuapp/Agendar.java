package com.example.withuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.withuapp.model.Cita;
import com.example.withuapp.model.Psicologo;
import com.example.withuapp.model.Usuario;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

public class Agendar extends AppCompatActivity {

    private TextView nombreDoc;
    private TextView hora;
    private TextView fecha;
    private Button agendarBtn;
    private ImageView atrasBtn;
    private ImageView imgPerfil;
    private Psicologo p;
    private int minHora;
    private int maxHora;
    private int randomHora;
    private int minMinuto;
    private int maxMinuto;
    private int randomMinuto;
    private int minDia, minMes;
    private int maxDia, maxMes;
    private int randomDia, randomMes;
    Calendar unaFecha;
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
        fecha=findViewById(R.id.fecha);
        atrasBtn=findViewById(R.id.atrasBtn);
        imgPerfil=findViewById(R.id.imgPerfil);

        //Mostrar el nombre del psicologo anteriormente seleccionado
        p=(Psicologo) getIntent().getExtras().getSerializable("psicologoNombre");
        nombreDoc.setText(p.toString());

        //Generar hora random de la cita a agendar
        minHora = 7;
        maxHora = 18;
        randomHora = new Random().nextInt((maxHora - minHora) + 1) + minHora;

        //Generar minuto random de la cita a agendar
        minMinuto = 10;
        maxMinuto = 59;
        randomMinuto = new Random().nextInt((maxMinuto - minMinuto) + 1) + minMinuto;

        //Generar dia random de la cita a agendar
        minDia = 1;
        maxDia = 30;
        randomDia = new Random().nextInt((maxDia - minDia) + 1) + minDia;

        //Generar mes random de la cita a agendar
        minMes = 6;
        maxMes = 9;
        randomMes = new Random().nextInt((maxMes - minMes) + 1) + minMes;

        //Formato de la fecha random asignada
        unaFecha=Calendar.getInstance();
        unaFecha.set(2020,randomMes,randomDia);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

        //Fecha random de la cita que se le muestra al usuario en la pantalla de Agendar
        String fechaAsignada=sdf.format(unaFecha.getTime());
        fecha.setText(fechaAsignada);

        //Hora random de la cita que se le muestra al usuario en la pantalla de Agendar
        String tiempoAsignado="";
        if(randomHora<=11){
            tiempoAsignado=randomHora+":"+randomMinuto+" A.M";
        }else{
            tiempoAsignado=randomHora+":"+randomMinuto+" P.M";
        }
        hora.setText(tiempoAsignado);
        String finalTiempoAsignado = tiempoAsignado;

        //Mostrar imagen del psicologo seleccionado
        if(p.toString().contains("Antonio"))
            imgPerfil.setImageResource(R.drawable.antonio_ruiz);
        if(p.toString().contains("Carla"))
            imgPerfil.setImageResource(R.drawable.carla_sandoval);
        if(p.toString().contains("Milena"))
            imgPerfil.setImageResource(R.drawable.milena_mesa);
        if(p.toString().contains("Jaime"))
            imgPerfil.setImageResource(R.drawable.jaime_ortiz);

        agendarBtn.setOnTouchListener(
                (v,event)->{
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            //Cambiar el color del boton cuando se da click
                            v.setBackgroundResource(R.drawable.pressed_button);
                            break;

                        case MotionEvent.ACTION_UP:
                            v.setBackgroundResource(R.drawable.rounded_button);

                            //Generar id de cada cita
                            String id=FirebaseDatabase.getInstance().getReference().child("Usuarios").child(user.getId())
                                    .child("Citas").push().getKey();

                            //Agregar la cita agendada a la base de datos
                            Cita cita=new Cita(id,fechaAsignada, finalTiempoAsignado,p.toString());
                            FirebaseDatabase.getInstance().getReference().child("Usuarios").child(user.getId())
                                    .child("Citas").child(id).setValue(cita);

                            //pasar a la pantalla de las citas agendadas
                            Intent in=new Intent(Agendar.this, Citas.class);
                            in.putExtra("usuarioActual",user);
                            startActivity(in);
                            break;
                    }
                    return true;
                }
        );

        atrasBtn.setOnClickListener(
                (v)->{
                    //Devolverse a la pantalla de los psicologos disponibles
                    Intent in=new Intent(Agendar.this, Psicologos.class);
                    startActivity(in);
                }
        );
    }
}
