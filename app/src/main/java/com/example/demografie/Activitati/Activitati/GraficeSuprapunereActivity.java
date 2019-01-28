package com.example.demografie.Activitati.Activitati;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.demografie.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraficeSuprapunereActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafice_suprapunere);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series=new LineGraphSeries<>();
        if(getIntent().getStringExtra("tip").equals("naturala")) {
            series = DateNatalitatePeAniActivity.preluareLineSeriesNatalitatePeAni(getApplicationContext());
            series.setColor(Color.GREEN);

            LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>();
            series1 = DateMortalitatePeAniActivity.preluareLineSeriesMortalitatePeAni(getApplicationContext());
            series1.setColor(Color.RED);

            series.setTitle("Natalitate");
            series1.setTitle("Mortalitate");
            graph.getLegendRenderer().setVisible(true);
            graph.getLegendRenderer().setBackgroundColor(android.R.color.white);
            graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);


            graph.addSeries(series);
            graph.addSeries(series1);

            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Natalitate-Mortalitate (1990-2016)");
//        Toast.makeText(getApplicationContext(),pozitie,Toast.LENGTH_SHORT).show();
        }
        else
        {
            series = DateImigrantiActivity.preluareLineSeriesImigranti(getApplicationContext());
            series.setColor(Color.GREEN);

            LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>();
            series1 = DateEmigrantiActivity.preluareLineSeriesEmigranti(getApplicationContext());
            series1.setColor(Color.RED);

            series.setTitle("Imigranti");
            series1.setTitle("Emigranti");
            graph.getLegendRenderer().setVisible(true);
            graph.getLegendRenderer().setBackgroundColor(android.R.color.white);
            graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);


            graph.addSeries(series);
            graph.addSeries(series1);

            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Imigratie-Emigratie (1990-2017)");
        }


        graph.getViewport().setScalableY(true);

// activate vertical scrolling
        graph.getViewport().setScrollableY(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}