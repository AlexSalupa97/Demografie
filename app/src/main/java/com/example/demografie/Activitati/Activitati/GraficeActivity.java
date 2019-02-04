package com.example.demografie.Activitati.Activitati;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.demografie.R;
import com.jjoe64.graphview.GraphView;

public class GraficeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafice);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        String tip=getIntent().getStringExtra("tip");

        if(getIntent().getStringExtra("tip").equals("natalitate"))
        {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Natalitatea pe ani (1990-2016)");
//        Toast.makeText(getApplicationContext(),pozitie,Toast.LENGTH_SHORT).show();

            graph.addSeries(DateNatalitatePeAniActivity.preluareLineSeriesNatalitatePeAni(getApplicationContext()));
        }
        else if(getIntent().getStringExtra("tip").equals("mortalitate")){

            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Mortalitatea pe ani (1990-2016)");
//        Toast.makeText(getApplicationContext(),pozitie,Toast.LENGTH_SHORT).show();

            graph.addSeries(DateMortalitatePeAniActivity.preluareLineSeriesMortalitatePeAni(getApplicationContext()));
        }
        else if(getIntent().getStringExtra("tip").equals("imigranti")){

            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Imigranti pe ani (1991-2017)");
//        Toast.makeText(getApplicationContext(),pozitie,Toast.LENGTH_SHORT).show();

            graph.addSeries(DateImigrantiActivity.preluareLineSeriesImigranti(getApplicationContext()));
        }
        else if(getIntent().getStringExtra("tip").equals("emigranti")){

            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle("Emigranti pe ani (1990-2017)");
//        Toast.makeText(getApplicationContext(),pozitie,Toast.LENGTH_SHORT).show();

            graph.addSeries(DateEmigrantiActivity.preluareLineSeriesEmigranti(getApplicationContext()));
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
