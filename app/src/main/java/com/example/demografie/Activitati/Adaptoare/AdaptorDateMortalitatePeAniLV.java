package com.example.demografie.Activitati.Adaptoare;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.demografie.Activitati.Clase.CSVMortalitatePeAni;
import com.example.demografie.R;

import java.util.ArrayList;

public class AdaptorDateMortalitatePeAniLV extends ArrayAdapter<CSVMortalitatePeAni> {

    public AdaptorDateMortalitatePeAniLV(Activity context, ArrayList<CSVMortalitatePeAni> lista) {
        super(context, 0, lista);
    }

    static class ViewHolder {
        public TextView tvAn;
        public TextView tvValoare;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewRefolosibil = convertView;
        CSVMortalitatePeAni curent = getItem(position);

        if (viewRefolosibil == null) {
            viewRefolosibil = LayoutInflater.from(getContext()).inflate(R.layout.structura_elem_natalitate_pe_ani, parent, false);


            ViewHolder viewHolder = new ViewHolder();

            viewHolder.tvAn = (TextView) viewRefolosibil.findViewById(R.id.tvAn);
            viewHolder.tvValoare = (TextView) viewRefolosibil.findViewById(R.id.tvValoare);

            viewRefolosibil.setTag(viewHolder);
        }


        ViewHolder holder = (ViewHolder) viewRefolosibil.getTag();


        holder.tvAn.setText(String.valueOf(curent.getAn()));
        holder.tvValoare.setText(String.valueOf(curent.getValoare()));

        return viewRefolosibil;


    }
}
