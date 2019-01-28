package com.example.demografie.Activitati.Fragmente;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.demografie.Activitati.Activitati.DateMortalitatePeAniActivity;
import com.example.demografie.Activitati.Activitati.DateNatalitatePeAniActivity;
import com.example.demografie.Activitati.Activitati.DateNatalitatePeJudeteActivity;
import com.example.demografie.Activitati.Activitati.GraficeActivity;
import com.example.demografie.Activitati.Activitati.GraficeBarActivity;
import com.example.demografie.Activitati.Activitati.GraficeSuprapunereActivity;
import com.example.demografie.Activitati.Adaptoare.AdaptorGraficeBareLV;
import com.example.demografie.Activitati.Adaptoare.AdaptorGraficeLV;
import com.example.demografie.Activitati.Clase.Grafice;
import com.example.demografie.Activitati.Clase.GraficeBare;
import com.example.demografie.R;
import com.jjoe64.graphview.GraphView;

import java.util.ArrayList;

public class GraficeFragment extends Fragment {

    View rootView;

    ListView listView;
    ListView listView1;
    public static ArrayList<Grafice> lista;
    public static ArrayList<GraficeBare> listaBare;
    Button btnSuprapunere;

    GraphView gvGraph;

    public GraficeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_grafice, container, false);

        lista = new ArrayList<>();
        lista.add(new Grafice("Natalitate pe ani (1990-2016)", DateNatalitatePeAniActivity.preluareLineSeriesNatalitatePeAni(getActivity())));
        lista.add(new Grafice("Mortalitate pe ani (1990-2016)", DateMortalitatePeAniActivity.preluareLineSeriesMortalitatePeAni(getActivity())));

        listView = (ListView) rootView.findViewById(R.id.lvGrafice);
        AdaptorGraficeLV adaptor = new AdaptorGraficeLV(getActivity(), lista);
        listView.setAdapter(adaptor);

        btnSuprapunere=(Button)rootView.findViewById(R.id.btnVizualizareSuprapunere);
        btnSuprapunere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GraficeSuprapunereActivity.class);
                startActivity(intent);
            }
        });




        listaBare=new ArrayList<>();
        listaBare.add(new GraficeBare("Natalitate 1960", DateNatalitatePeJudeteActivity.preluareBarSeriesNatalitate1960(getActivity())));
        listaBare.add(new GraficeBare("Natalitate 2016", DateNatalitatePeJudeteActivity.preluareBarSeriesNatalitate2016(getActivity())));
        listView1=(ListView) rootView.findViewById(R.id.lvGrafice1);
        AdaptorGraficeBareLV adaptorBare=new AdaptorGraficeBareLV(getActivity(),listaBare);
        listView1.setAdapter(adaptorBare);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), GraficeActivity.class);
                intent.putExtra("pozitie",String.valueOf(position));
                startActivity(intent);
            }
        });

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), GraficeBarActivity.class);
                intent.putExtra("pozitie",String.valueOf(position));
                startActivity(intent);
            }
        });





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
