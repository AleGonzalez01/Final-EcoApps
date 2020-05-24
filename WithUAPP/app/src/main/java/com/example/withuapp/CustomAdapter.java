package com.example.withuapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.withuapp.model.Psicologo;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<Psicologo>psico;

    public CustomAdapter (){
        psico=new ArrayList<>();
    }
    @Override
    public int getCount() {
        return psico.size();
    }

    @Override
    public Object getItem(int position) {
        return psico.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View row=inflater.inflate(R.layout.renglonpsicologos,null);
        TextView nombreRenglon=row.findViewById(R.id.nombreRenglon);
        nombreRenglon.setText(psico.get(position).getNombre()+" "+psico.get(position).getApellido());

        ImageView perfilImg=row.findViewById(R.id.perfilImg);

        //Mostrar imagenes de los psicologos de la lista
        if(psico.get(position).getNombre().contains("Antonio"))
            perfilImg.setImageResource(R.drawable.antonio_ruiz);
        if(psico.get(position).getNombre().contains("Carla"))
            perfilImg.setImageResource(R.drawable.carla_sandoval);
        if(psico.get(position).getNombre().contains("Milena"))
            perfilImg.setImageResource(R.drawable.milena_mesa);
        if(psico.get(position).getNombre().contains("Jaime"))
            perfilImg.setImageResource(R.drawable.jaime_ortiz);

        return row;
    }

    public void agregarPsicologos(Psicologo doctor){
        psico.add(doctor);
        this.notifyDataSetChanged();
    }

    public ArrayList<Psicologo> getPsico() {
        return psico;
    }

    public void setPsico(ArrayList<Psicologo> psico) {
        this.psico = psico;
    }
}
