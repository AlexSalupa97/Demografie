package com.example.demografie.Activitati.Fragmente;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.demografie.Activitati.Activitati.DateNatalitatePeJudeteActivity;
import com.example.demografie.Activitati.Activitati.GraficeBarActivity;
import com.example.demografie.Activitati.Adaptoare.AdaptorGraficeBareLV;
import com.example.demografie.Activitati.Clase.GraficeBare;
import com.example.demografie.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GraficeFragment1 extends Fragment {

    View rootView;
    ListView listView1;
    public static ArrayList<GraficeBare> listaBare;


    public GraficeFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_grafice_fragment1, container, false);

        listaBare=new ArrayList<>();
        listaBare.add(new GraficeBare("Natalitate 1960", DateNatalitatePeJudeteActivity.preluareBarSeriesNatalitate1960(getActivity())));
        listaBare.add(new GraficeBare("Natalitate 2016", DateNatalitatePeJudeteActivity.preluareBarSeriesNatalitate2016(getActivity())));
        listView1=(ListView) rootView.findViewById(R.id.lvGrafice1);
        AdaptorGraficeBareLV adaptorBare=new AdaptorGraficeBareLV(getActivity(),listaBare);
        listView1.setAdapter(adaptorBare);


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), GraficeBarActivity.class);
                intent.putExtra("pozitie",String.valueOf(position));
                startActivity(intent);
            }
        });
        return rootView;
    }

}
