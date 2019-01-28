package com.example.demografie.Activitati.Adaptoare;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.demografie.Activitati.Clase.CSVNatalitate;
import com.example.demografie.R;

import java.util.ArrayList;

public class AdaptorDateNatalitatiLV extends ArrayAdapter<CSVNatalitate> {

    public AdaptorDateNatalitatiLV(Activity context, ArrayList<CSVNatalitate> lista) {
        super(context, 0, lista);
    }

    static class ViewHolder {
        public TextView tvJudet;
        public TextView tv1960;
        public TextView tv2016;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewRefolosibil = convertView;
        CSVNatalitate curent = getItem(position);

        if (viewRefolosibil == null) {
            viewRefolosibil = LayoutInflater.from(getContext()).inflate(R.layout.structura_elem_date_natalitate, parent, false);


            ViewHolder viewHolder = new ViewHolder();

            viewHolder.tvJudet = (TextView) viewRefolosibil.findViewById(R.id.tvJudet);
            viewHolder.tv1960 = (TextView) viewRefolosibil.findViewById(R.id.tv1960);
            viewHolder.tv2016 = (TextView) viewRefolosibil.findViewById(R.id.tv2016);

            viewRefolosibil.setTag(viewHolder);
        }


        ViewHolder holder = (ViewHolder) viewRefolosibil.getTag();


        holder.tvJudet.setText(curent.getJudet());
        holder.tv1960.setText("1960: "+String.valueOf(curent.getNumarNouNascuti1960()));
        holder.tv2016.setText("2016: "+String.valueOf(curent.getNumarNouNascuti2016()));

        return viewRefolosibil;


    }
}
