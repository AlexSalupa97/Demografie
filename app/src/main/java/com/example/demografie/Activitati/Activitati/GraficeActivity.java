package com.example.demografie.Activitati.Activitati;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.demografie.Activitati.Fragmente.GraficeFragment;
import com.example.demografie.R;
import com.jjoe64.graphview.GraphView;

public class GraficeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafice);

        GraphView graph = (GraphView) findViewById(R.id.graph);
        String pozitie = getIntent().getStringExtra("pozitie");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle(GraficeFragment.lista.get(Integer.valueOf(pozitie)).getTitlu());
//        Toast.makeText(getApplicationContext(),pozitie,Toast.LENGTH_SHORT).show();

        graph.addSeries(GraficeFragment.lista.get(Integer.parseInt(pozitie)).getSeries());

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
