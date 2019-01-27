package com.example.demografie.Activitati.Fragmente;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.demografie.Activitati.Adaptoare.AdaptorGraficeLV;
import com.example.demografie.Activitati.Clase.Grafice;
import com.example.demografie.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class GraficeFragment extends Fragment {

    View rootView;

    ListView listView;
    ArrayList<Grafice> lista;

    public GraficeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_grafice, container, false);

        lista = new ArrayList<>();
        lista.add(new Grafice("Grafic1", new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(6, 20)
        })));
        lista.add(new Grafice("Grafic2", new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(6, 20),
                new DataPoint(8, 20),
                new DataPoint(9, 20),
                new DataPoint(30, 20),
                new DataPoint(100, 20)
        })));

        lista.add(new Grafice("Grafic3", new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(6, 20),
                new DataPoint(8, 20),
                new DataPoint(9, 20),
                new DataPoint(30, 20),
                new DataPoint(100, 20)
        })));

        lista.add(new Grafice("Grafic4", new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(6, 20),
                new DataPoint(8, 20),
                new DataPoint(9, 20),
                new DataPoint(30, 20),
                new DataPoint(100, 20)
        })));
        listView = (ListView) rootView.findViewById(R.id.lvGrafice);
        AdaptorGraficeLV adaptor = new AdaptorGraficeLV(getActivity(), lista);
        listView.setAdapter(adaptor);

        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(6, 20)
        });
        graph.addSeries(series);

        GraphView graph1 = (GraphView) rootView.findViewById(R.id.graph1);
        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(2, 3),
                new DataPoint(6, 20),
                new DataPoint(7, 20),
                new DataPoint(8, 20),
                new DataPoint(9, 20),
                new DataPoint(30, 20),
                new DataPoint(100, 20)

        });
        graph1.addSeries(series1);

        graph1.getViewport().setMinX(0);

        // activate horizontal zooming and scrolling
        graph.getViewport().setScalable(true);

// activate horizontal scrolling
        graph.getViewport().setScrollable(true);

// activate horizontal and vertical zooming and scrolling
        graph.getViewport().setScalableY(true);

// activate vertical scrolling
        graph.getViewport().setScrollableY(true);


        // activate horizontal zooming and scrolling
        graph1.getViewport().setScalable(true);

// activate horizontal scrolling
        graph1.getViewport().setScrollable(true);

// activate horizontal and vertical zooming and scrolling
        graph1.getViewport().setScalableY(true);

// activate vertical scrolling
        graph1.getViewport().setScrollableY(true);

        return rootView;
    }
}
