package com.example.demografie.Activitati.Activitati;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.demografie.Activitati.Adaptoare.AdaptorDateMortalitatePeAniLV;
import com.example.demografie.Activitati.Clase.CSVMortalitatePeAni;
import com.example.demografie.R;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DateEmigrantiActivity extends AppCompatActivity {

    CSVReader reader;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_mortalitate_pe_ani);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Emigranti pe ani");


        StringBuilder sb = new StringBuilder();

        List<String[]> listaString = null;

        try {
            reader = new CSVReader(new InputStreamReader(getResources().openRawResource(R.raw.emigranti_ani)));
            try {
                listaString = reader.readAll();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {

        }


        ArrayList<CSVMortalitatePeAni> listaMortalitatePeAni = new ArrayList<>();

        int j = 1990;
        for (int i = 0; i < listaString.size(); i = i + 1) {
            String[] s = listaString.get(i);
            listaMortalitatePeAni.add(new CSVMortalitatePeAni(j, Integer.valueOf(s[0])));
            j++;
        }
        listView = (ListView) findViewById(R.id.lvMortalitate);
        AdaptorDateMortalitatePeAniLV adaptorDateMortalitatePeAniLV = new AdaptorDateMortalitatePeAniLV(this, listaMortalitatePeAni);
        listView.setAdapter(adaptorDateMortalitatePeAniLV);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public static LineGraphSeries<DataPoint> preluareLineSeriesEmigranti(Context context)
    {
        CSVReader reader;
        StringBuilder sb = new StringBuilder();

        List<String[]> listaString = null;

        try {
            reader = new CSVReader(new InputStreamReader(context.getResources().openRawResource(R.raw.emigranti_ani)));
            try {
                listaString = reader.readAll();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {

        }


        ArrayList<CSVMortalitatePeAni> listaMortalitatePeAni = new ArrayList<>();

        int j = 1990;
        for (int i = 0; i < listaString.size(); i = i + 1) {
            String[] s = listaString.get(i);
            listaMortalitatePeAni.add(new CSVMortalitatePeAni(j, Integer.valueOf(s[0])));
            j++;
        }

        LineGraphSeries<DataPoint> series=new LineGraphSeries<>();
        for (int i = 0; i < listaMortalitatePeAni.size(); i++) {
            series.appendData(new DataPoint(listaMortalitatePeAni.get(i).getAn(), listaMortalitatePeAni.get(i).getValoare()), false, 100);
        }
        return series;
    }

    public static ArrayList<CSVMortalitatePeAni> preluareEmigrantiPeAni(Context context)
    {
        CSVReader reader;
        StringBuilder sb = new StringBuilder();

        List<String[]> listaString = null;

        try {
            reader = new CSVReader(new InputStreamReader(context.getResources().openRawResource(R.raw.emigranti_ani)));
            try {
                listaString = reader.readAll();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {

        }


        ArrayList<CSVMortalitatePeAni> listaMortalitatePeAni = new ArrayList<>();

        int j = 1990;
        for (int i = 0; i < listaString.size(); i = i + 1) {
            String[] s = listaString.get(i);
            listaMortalitatePeAni.add(new CSVMortalitatePeAni(j, Integer.valueOf(s[0])));
            j++;
        }
        return listaMortalitatePeAni;
    }
}
