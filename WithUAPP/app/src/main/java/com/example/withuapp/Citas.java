package com.example.withuapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.withuapp.model.Cita;
import com.example.withuapp.model.Usuario;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Citas extends AppCompatActivity {
    private ListView listaCitas;
    private CustomAdapter2 adapter2;
    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        listaCitas=findViewById(R.id.listaCitas);

        user=(Usuario) getIntent().getExtras().getSerializable("usuarioActual");
        adapter2=new CustomAdapter2();
        listaCitas.setAdapter(adapter2);


        FirebaseDatabase.getInstance().getReference().child("Usuarios").child(user.getId()).child("Citas")
                .addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        //Mostrar las citas que se han agendado anteriormente
                        Cita cita=dataSnapshot.getValue(Cita.class);
                        adapter2.agregarPsicologos(cita);
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
