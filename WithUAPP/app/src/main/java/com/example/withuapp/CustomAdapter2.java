package com.example.withuapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.withuapp.model.Cita;

import java.util.ArrayList;

public class CustomAdapter2 extends BaseAdapter {

    private ArrayList<Cita>citasR;

    public CustomAdapter2(){
        citasR=new ArrayList<>();
    }
    @Override
    public int getCount() {
        return citasR.size();
    }

    @Override
    public Object getItem(int position) {
        return citasR.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View row=inflater.inflate(R.layout.rengloncitas,null);

        TextView nombreCita=row.findViewById(R.id.nombreCita);
        //Mostrar el nombre de cada psicologo de la lista
        nombreCita.setText("Cita con "+citasR.get(position).getNombrePsico());

        TextView fechaRenglon=row.findViewById(R.id.fechaRenglon);
        //Mostrar la fecha de cada cita agendada
        fechaRenglon.setText(citasR.get(position).getFecha()+" - "+citasR.get(position).getHora());

        ImageView imagenPsico=row.findViewById(R.id.imagenPsico);
        //Mostrar imagenes de los psicologos de la lista
        if(citasR.get(position).getNombrePsico().contains("Antonio"))
            imagenPsico.setImageResource(R.drawable.antonio_ruiz);
        if(citasR.get(position).getNombrePsico().contains("Milena"))
            imagenPsico.setImageResource(R.drawable.milena_mesa);
        if(citasR.get(position).getNombrePsico().contains("Carla"))
            imagenPsico.setImageResource(R.drawable.carla_sandoval);
        if(citasR.get(position).getNombrePsico().contains("Jaime"))
            imagenPsico.setImageResource(R.drawable.jaime_ortiz);

        return row;
    }

    public void agregarPsicologos(Cita citaR){
        citasR.add(citaR);
        this.notifyDataSetChanged();
    }

    public ArrayList<Cita> getCitasR() {
        return citasR;
    }

    public void setCitasR(ArrayList<Cita> citasR) {
        this.citasR = citasR;
    }
}
