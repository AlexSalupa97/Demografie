package com.example.demografie.Activitati.Activitati;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.demografie.Activitati.Adaptoare.AdaptorDateNatalitatiPeAniLV;
import com.example.demografie.Activitati.Clase.CSVNatalitatePeAni;
import com.example.demografie.R;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DateNatalitatePeAniActivity extends AppCompatActivity {

    CSVReader reader;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_natalitate_pe_ani);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Natalitatea pe ani");


        StringBuilder sb = new StringBuilder();

        List<String[]> listaString = null;

        try {
            reader = new CSVReader(new InputStreamReader(getResources().openRawResource(R.raw.natalitate_ani)));
            try {
                listaString = reader.readAll();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {

        }


        ArrayList<CSVNatalitatePeAni> listaNatalitatePeAni = new ArrayList<>();

        int j=1990;
        for (int i = 0; i < listaString.size(); i = i + 1) {
            String[] s = listaString.get(i);
            listaNatalitatePeAni.add(new CSVNatalitatePeAni(j,Integer.valueOf(s[0])));
            j++;
        }
        listView = (ListView) findViewById(R.id.lvNatalitate);
        AdaptorDateNatalitatiPeAniLV adaptorDateNatalitatiLV = new AdaptorDateNatalitatiPeAniLV(this, listaNatalitatePeAni);
        listView.setAdapter(adaptorDateNatalitatiLV);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public static LineGraphSeries<DataPoint> preluareLineSeriesNatalitatePeAni(Context context)
    {
        CSVReader reader;
        StringBuilder sb = new StringBuilder();

        List<String[]> listaString = null;

        try {
            reader = new CSVReader(new InputStreamReader(context.getResources().openRawResource(R.raw.natalitate_ani)));
            try {
                listaString = reader.readAll();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {

        }


        ArrayList<CSVNatalitatePeAni> listaNatalitatePeAni = new ArrayList<>();

        int j=1990;
        for (int i = 0; i < listaString.size(); i = i + 1) {
            String[] s = listaString.get(i);
            listaNatalitatePeAni.add(new CSVNatalitatePeAni(j,Integer.valueOf(s[0])));
            j++;
        }

        LineGraphSeries<DataPoint> series=new LineGraphSeries<>();
        for (int i = 0; i < listaNatalitatePeAni.size(); i++) {
            series.appendData(new DataPoint(listaNatalitatePeAni.get(i).getAn(), listaNatalitatePeAni.get(i).getValoare()), false, 100);
        }
        return series;
    }

    public static ArrayList<CSVNatalitatePeAni> preluareNatalitatePeAni(Context context)
    {
        CSVReader reader;
        StringBuilder sb = new StringBuilder();

        List<String[]> listaString = null;

        try {
            reader = new CSVReader(new InputStreamReader(context.getResources().openRawResource(R.raw.natalitate_ani)));
            try {
                listaString = reader.readAll();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {

        }


        ArrayList<CSVNatalitatePeAni> listaNatalitatePeAni = new ArrayList<>();

        int j=1990;
        for (int i = 0; i < listaString.size(); i = i + 1) {
            String[] s = listaString.get(i);
            listaNatalitatePeAni.add(new CSVNatalitatePeAni(j,Integer.valueOf(s[0])));
            j++;
        }
        return listaNatalitatePeAni;
    }
}
