package com.example.alquimaraalves.teste.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alquimaraalves.teste.Contato;
import com.example.alquimaraalves.teste.R;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Contato>{
    private ArrayList<Contato> contatoes;
    private Context context;
    public Adapter(Context context, ArrayList<Contato> objects) {
        super(context,0 , objects);
        this.context = context;
        this.contatoes = objects;
    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        View view = null;
        if(contatoes != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista, parent, false);
            TextView textViewNome = view.findViewById(R.id.textViewNome);
            TextView textViewTel = view.findViewById(R.id.textViewTel);
            TextView textViewEnd = view.findViewById(R.id.textViewEnd);
            Contato produtos2 = contatoes.get(position);
            textViewNome.setText(produtos2.getNome());
            textViewTel.setText(produtos2.getTelefone().toString());
            textViewEnd.setText(produtos2.getEndereco().toString());

        }

        return view;
    }
}
