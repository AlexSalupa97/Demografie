package com.example.demografie.Activitati.Adaptoare;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.demografie.Activitati.Clase.Populatie;
import com.example.demografie.Activitati.Fragmente.CalculIndicatoriFragment;
import com.example.demografie.R;

import java.util.ArrayList;

public class AdaptorPopulatie extends ArrayAdapter<Populatie> {

    public AdaptorPopulatie(Activity context, ArrayList<Populatie> lista) {
        super(context, 0, lista);
    }

    static class ViewHolder {
        public TextView tvAn;
        public TextView tvVariatieMigratoare;
        public TextView tvVariatieNaturala;
        public TextView tvPopDeclarata;
        public TextView tvPopCalculata;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewRefolosibil = convertView;
        Populatie curent = getItem(position);

        if (viewRefolosibil == null) {
            viewRefolosibil = LayoutInflater.from(getContext()).inflate(R.layout.structura_elem_populatie, parent, false);


            ViewHolder viewHolder = new ViewHolder();

            viewHolder.tvAn = (TextView) viewRefolosibil.findViewById(R.id.tvAn);
            viewHolder.tvVariatieMigratoare = (TextView) viewRefolosibil.findViewById(R.id.tvVariatieMigratoare);
            viewHolder.tvVariatieNaturala = (TextView) viewRefolosibil.findViewById(R.id.tvVariatieNaturala);
            viewHolder.tvPopDeclarata = (TextView) viewRefolosibil.findViewById(R.id.tvPopDeclarata);
            viewHolder.tvPopCalculata = (TextView) viewRefolosibil.findViewById(R.id.tvPopCalculata);

            viewRefolosibil.setTag(viewHolder);
        }


        ViewHolder holder = (ViewHolder) viewRefolosibil.getTag();


        holder.tvAn.setText(String.valueOf(curent.getAn()));
        holder.tvVariatieMigratoare.setText("Var. migratoare: "+String.valueOf(curent.getVariatieMigratoare()));
        holder.tvVariatieNaturala.setText("Var. naturala: "+String.valueOf(curent.getVariatieNaturala()));
        holder.tvPopDeclarata.setText("Pop. declarata: "+String.valueOf(curent.getPopulatieDeclarata()));
        holder.tvPopCalculata.setText("Pop. calculata: "+String.valueOf(curent.getPopulatieCalculata()));

        if(curent.getPopulatieDeclarata()-curent.getPopulatieCalculata()< CalculIndicatoriFragment.valoare)
            viewRefolosibil.setBackgroundResource(R.drawable.gradient_ok);
        else
            viewRefolosibil.setBackgroundResource(R.drawable.gradient_not_ok);



        return viewRefolosibil;


    }
}
