package com.example.demografie.Activitati.Adaptoare;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.demografie.Activitati.Clase.Grafice;
import com.example.demografie.R;
import com.jjoe64.graphview.GraphView;

import java.util.ArrayList;

public class AdaptorGraficeLV extends ArrayAdapter<Grafice> {


    public AdaptorGraficeLV(Activity context, ArrayList<Grafice> lista) {
        super(context, 0, lista);
    }

    static class ViewHolder {
        public GraphView graphView;
        public TextView textView;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View viewRefolosibil = convertView;
        Grafice curent = getItem(position);

        if (viewRefolosibil == null) {
            viewRefolosibil = LayoutInflater.from(getContext()).inflate(R.layout.structura_elem_grafic, parent, false);


            ViewHolder viewHolder = new ViewHolder();

            viewHolder.graphView = (GraphView) viewRefolosibil.findViewById(R.id.gvGraph);
            viewHolder.textView = (TextView) viewRefolosibil.findViewById(R.id.tvText);

            viewRefolosibil.setTag(viewHolder);
        }


        ViewHolder holder = (ViewHolder) viewRefolosibil.getTag();


        holder.graphView.addSeries(curent.getSeries());
        holder.textView.setText(curent.getTitlu());

//

// activate horizontal and vertical zooming and scrolling
        holder.graphView.getViewport().setScalableY(true);

// activate vertical scrolling
        holder.graphView.getViewport().setScrollableY(true);
        return viewRefolosibil;


    }
}
