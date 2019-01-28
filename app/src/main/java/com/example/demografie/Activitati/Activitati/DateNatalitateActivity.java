package com.example.demografie.Activitati.Activitati;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.demografie.Activitati.Adaptoare.AdaptorDateNatalitatiLV;
import com.example.demografie.Activitati.Clase.CSVNatalitate;
import com.example.demografie.R;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DateNatalitateActivity extends AppCompatActivity {

    TextView tvVizualziareDate;
    public static BarGraphSeries<DataPoint> series;
    CSVReader reader;

    ListView lvNatalitate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_natalitate);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Natalitate");


        StringBuilder sb = new StringBuilder();

        List<String[]> listaString = null;

        try {
            reader = new CSVReader(new InputStreamReader(getResources().openRawResource(R.raw.natalitate1)));
            try {
                listaString = reader.readAll();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {

        }


        ArrayList<CSVNatalitate> listaNatalitate = new ArrayList<>();

        for (int i = 0; i < listaString.size(); i = i + 2) {
            String[] s = listaString.get(i);
            String[] s1 = listaString.get(i + 1);
            listaNatalitate.add(new CSVNatalitate(s[0], Integer.valueOf(s[1]), Integer.valueOf(s1[1])));
            sb.append(i / 2 + " " + s[0] + " " + s[1] + " " + s1[1]);
            sb.append("\n");
        }
//        tvVizualziareDate = (TextView) findViewById(R.id.tvVizualizareDate);
//        tvVizualziareDate.setText(sb.toString());


//        GraphView graph = (GraphView) findViewById(R.id.graph);
//        String[] labelX=new String[listaNatalitate.size()];
//        series = new BarGraphSeries<>();
//        for(int i=0;i<listaNatalitate.size();i++) {
//            series.appendData(new DataPoint(i, listaNatalitate.get(i).getNumarNouNascuti2016()), false, 100);
//            labelX[i]=listaNatalitate.get(i).getJudet();
//        }
//        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);

//        staticLabelsFormatter.setHorizontalLabels(labelX);
//        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
//        series.setSpacing(5);
//
//        series.setDrawValuesOnTop(true);
//        graph.addSeries(series);
//
//        graph.getViewport().setScalableY(true);
//
//        graph.getViewport().setScrollableY(true);
//
//
//        GraphView graph1 = (GraphView) findViewById(R.id.graph1);
//        BarGraphSeries<DataPoint> series1 = new BarGraphSeries<>();
//        for(int i=0;i<listaNatalitate.size();i++) {
//            series1.appendData(new DataPoint(i, listaNatalitate.get(i).getNumarNouNascuti1960()), false, 100);
//        }
////        StaticLabelsFormatter staticLabelsFormatter1 = new StaticLabelsFormatter(graph1);
//
////        staticLabelsFormatter1.setHorizontalLabels(labelX);
//
////        graph1.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter1);
//        series1.setSpacing(5);
//
//        series1.setDrawValuesOnTop(true);
//        graph1.addSeries(series1);
//
//        graph1.getViewport().setScalableY(true);
//
//        graph1.getViewport().setScrollableY(true);


        lvNatalitate = (ListView) findViewById(R.id.lvNatalitate);
        AdaptorDateNatalitatiLV adaptorDateNatalitatiLV=new AdaptorDateNatalitatiLV(this,listaNatalitate);
        lvNatalitate.setAdapter(adaptorDateNatalitatiLV);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


    public static BarGraphSeries<DataPoint> preluareBarSeriesNatalitate2016(Context context) {
        CSVReader reader;
        StringBuilder sb = new StringBuilder();

        List<String[]> listaString = null;

        try {
            reader = new CSVReader(new InputStreamReader(context.getResources().openRawResource(R.raw.natalitate1)));
            try {
                listaString = reader.readAll();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {

        }


        ArrayList<CSVNatalitate> listaNatalitate = new ArrayList<>();

        for (int i = 0; i < listaString.size(); i = i + 2) {
            String[] s = listaString.get(i);
            String[] s1 = listaString.get(i + 1);
            listaNatalitate.add(new CSVNatalitate(s[0], Integer.valueOf(s[1]), Integer.valueOf(s1[1])));

        }
        series = new BarGraphSeries<>();
        for (int i = 0; i < listaNatalitate.size(); i++) {
            series.appendData(new DataPoint(i, listaNatalitate.get(i).getNumarNouNascuti2016()), false, 100);
        }
        return series;

    }

    public static BarGraphSeries<DataPoint> preluareBarSeriesNatalitate1960(Context context) {
        CSVReader reader;
        StringBuilder sb = new StringBuilder();

        List<String[]> listaString = null;

        try {
            reader = new CSVReader(new InputStreamReader(context.getResources().openRawResource(R.raw.natalitate1)));
            try {
                listaString = reader.readAll();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {

        }


        ArrayList<CSVNatalitate> listaNatalitate = new ArrayList<>();

        for (int i = 0; i < listaString.size(); i = i + 2) {
            String[] s = listaString.get(i);
            String[] s1 = listaString.get(i + 1);
            listaNatalitate.add(new CSVNatalitate(s[0], Integer.valueOf(s[1]), Integer.valueOf(s1[1])));

        }
        series = new BarGraphSeries<>();
        for (int i = 0; i < listaNatalitate.size(); i++) {
            series.appendData(new DataPoint(i, listaNatalitate.get(i).getNumarNouNascuti1960()), false, 100);
        }
        return series;

    }
}
