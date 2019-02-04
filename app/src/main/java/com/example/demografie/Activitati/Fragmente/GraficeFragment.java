package com.example.demografie.Activitati.Fragmente;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.demografie.Activitati.Activitati.DateEmigrantiActivity;
import com.example.demografie.Activitati.Activitati.DateImigrantiActivity;
import com.example.demografie.Activitati.Activitati.DateMortalitatePeAniActivity;
import com.example.demografie.Activitati.Activitati.DateNatalitatePeAniActivity;
import com.example.demografie.Activitati.Activitati.GraficeActivity;
import com.example.demografie.Activitati.Activitati.GraficeSuprapunereActivity;
import com.example.demografie.Activitati.Clase.Grafice;
import com.example.demografie.Activitati.Clase.GraficeBare;
import com.example.demografie.R;
import com.jjoe64.graphview.GraphView;

import java.util.ArrayList;

public class GraficeFragment extends Fragment {

    View rootView;

    ListView listView;
    ListView listViewMigratie;
    ListView listView1;
    public static ArrayList<Grafice> lista;
    public static ArrayList<GraficeBare> listaBare;
    public static ArrayList<Grafice> listaMigratii;
    Button btnSuprapunere;
    Button btnSuprapunereMigratii;

    GraphView gvNat;
    GraphView gvMort;
    GraphView gvImig;
    GraphView gvEmig;

    public GraficeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_grafice, container, false);

        gvNat = (GraphView) rootView.findViewById(R.id.gvNat);
        gvMort = (GraphView) rootView.findViewById(R.id.gvMort);
        gvImig = (GraphView) rootView.findViewById(R.id.gvImig);
        gvEmig = (GraphView) rootView.findViewById(R.id.gvEmig);

//        lista = new ArrayList<>();
//        lista.add(new Grafice("Natalitate pe ani (1990-2016)", DateNatalitatePeAniActivity.preluareLineSeriesNatalitatePeAni(getActivity())));
//        lista.add(new Grafice("Mortalitate pe ani (1990-2016)", DateMortalitatePeAniActivity.preluareLineSeriesMortalitatePeAni(getActivity())));

        gvNat.setTitle("Natalitatea pe ani (1990-2016)");
        gvMort.setTitle("Mortalitatea pe ani (1990-2016)");

        gvNat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GraficeActivity.class);
                intent.putExtra("tip","natalitate");
                startActivity(intent);
            }
        });

        gvMort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GraficeActivity.class);
                intent.putExtra("tip","mortalitate");
                startActivity(intent);
            }
        });

        gvNat.addSeries(DateNatalitatePeAniActivity.preluareLineSeriesNatalitatePeAni(getActivity()));
        gvMort.addSeries(DateMortalitatePeAniActivity.preluareLineSeriesMortalitatePeAni(getActivity()));

        gvNat.getViewport().setScalableY(true);
        gvNat.getViewport().setScrollableY(true);

        gvMort.getViewport().setScalableY(true);
        gvMort.getViewport().setScrollableY(true);
//
//        listView = (ListView) rootView.findViewById(R.id.lvGrafice);
//        AdaptorGraficeLV adaptor = new AdaptorGraficeLV(getActivity(), lista);
//        listView.setAdapter(adaptor);

        btnSuprapunere = (Button) rootView.findViewById(R.id.btnVizualizareSuprapunere);
        btnSuprapunere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GraficeSuprapunereActivity.class);
                intent.putExtra("tip", "naturala");
                startActivity(intent);
            }
        });

//        listaMigratii = new ArrayList<>();
//        listaMigratii.add(new Grafice("Emigranti pe ani (1990-2017)", DateEmigrantiActivity.preluareLineSeriesEmigranti(getActivity())));
//        listaMigratii.add(new Grafice("Imigranti pe ani (1991-2017)", DateImigrantiActivity.preluareLineSeriesImigranti(getActivity())));

        gvImig.setTitle("Imigranti pe ani (1991-2017)");
        gvEmig.setTitle("Emigranti pe ani (1990-2017)");

        gvImig.addSeries(DateImigrantiActivity.preluareLineSeriesImigranti(getActivity()));
        gvEmig.addSeries(DateEmigrantiActivity.preluareLineSeriesEmigranti(getActivity()));

        gvImig.getViewport().setScalableY(true);
        gvImig.getViewport().setScrollableY(true);

        gvEmig.getViewport().setScalableY(true);
        gvEmig.getViewport().setScrollableY(true);

        gvImig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GraficeActivity.class);
                intent.putExtra("tip","imigranti");
                startActivity(intent);
            }
        });

        gvEmig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GraficeActivity.class);
                intent.putExtra("tip","emigranti");
                startActivity(intent);
            }
        });


//        listViewMigratie = (ListView) rootView.findViewById(R.id.lvGraficeMigratie);
//        AdaptorGraficeLV adaptorMigratie = new AdaptorGraficeLV(getActivity(), listaMigratii);
//        listViewMigratie.setAdapter(adaptorMigratie);


        btnSuprapunereMigratii = (Button) rootView.findViewById(R.id.btnVizualizareSuprapunereMigratie);
        btnSuprapunereMigratii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GraficeSuprapunereActivity.class);
                intent.putExtra("tip", "migratie");
                startActivity(intent);
            }
        });

//        listaBare = new ArrayList<>();
//        listaBare.add(new GraficeBare("Natalitate 1960", DateNatalitatePeJudeteActivity.preluareBarSeriesNatalitate1960(getActivity())));
//        listaBare.add(new GraficeBare("Natalitate 2016", DateNatalitatePeJudeteActivity.preluareBarSeriesNatalitate2016(getActivity())));
//        listView1 = (ListView) rootView.findViewById(R.id.lvGrafice1);
//        AdaptorGraficeBareLV adaptorBare = new AdaptorGraficeBareLV(getActivity(), listaBare);
//        listView1.setAdapter(adaptorBare);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getActivity(), GraficeActivity.class);
//                intent.putExtra("pozitie", String.valueOf(position));
//                intent.putExtra("tip","natural");
//                startActivity(intent);
//            }
//        });
//
//        listViewMigratie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getActivity(), GraficeActivity.class);
//                intent.putExtra("tip","migratie");
//                intent.putExtra("pozitie", String.valueOf(position));
//                startActivity(intent);
//            }
//        });
//
//        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getActivity(), GraficeBarActivity.class);
//                intent.putExtra("pozitie", String.valueOf(position));
//                startActivity(intent);
//            }
//        });


//        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
//                new DataPoint(0, 1),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(6, 20)
//        });
//        graph.addSeries(series);
//
//        GraphView graph1 = (GraphView) rootView.findViewById(R.id.graph1);
//        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(new DataPoint[]{
//                new DataPoint(2, 3),
//                new DataPoint(6, 20),
//                new DataPoint(7, 20),
//                new DataPoint(8, 20),
//                new DataPoint(9, 20),
//                new DataPoint(30, 20),
//                new DataPoint(100, 20)
//
//        });
//        graph1.addSeries(series1);
//
//        graph1.getViewport().setMinX(0);
//
//        // activate horizontal zooming and scrolling
//        graph.getViewport().setScalable(true);
//
//// activate horizontal scrolling
//        graph.getViewport().setScrollable(true);
//
//// activate horizontal and vertical zooming and scrolling
//        graph.getViewport().setScalableY(true);
//
//// activate vertical scrolling
//        graph.getViewport().setScrollableY(true);
//
//
//        // activate horizontal zooming and scrolling
//        graph1.getViewport().setScalable(true);
//
//// activate horizontal scrolling
//        graph1.getViewport().setScrollable(true);
//
//// activate horizontal and vertical zooming and scrolling
//        graph1.getViewport().setScalableY(true);
//
//// activate vertical scrolling
//        graph1.getViewport().setScrollableY(true);

        return rootView;
    }
}
