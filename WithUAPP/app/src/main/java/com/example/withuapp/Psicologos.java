package com.example.withuapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.withuapp.model.Psicologo;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Psicologos extends AppCompatActivity {

    private ListView listaPsicologos;
    private ArrayList <Psicologo> psicologos;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psicologos);

        listaPsicologos=findViewById(R.id.listaPsicologos);

        adapter=new CustomAdapter();
        listaPsicologos.setAdapter(adapter);


        FirebaseDatabase.getInstance().getReference().child("Psicologos").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Psicologo psicologo=dataSnapshot.getValue(Psicologo.class);
                adapter.agregarPsicologos(psicologo);
                Toast.makeText(Psicologos.this, ""+psicologo.getNombre()+" "+psicologo.getApellido(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
