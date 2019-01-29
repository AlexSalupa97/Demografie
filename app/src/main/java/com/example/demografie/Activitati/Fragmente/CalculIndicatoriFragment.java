package com.example.demografie.Activitati.Fragmente;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.demografie.Activitati.Activitati.DateEmigrantiActivity;
import com.example.demografie.Activitati.Activitati.DateImigrantiActivity;
import com.example.demografie.Activitati.Activitati.DateMortalitatePeAniActivity;
import com.example.demografie.Activitati.Activitati.DateNatalitatePeAniActivity;
import com.example.demografie.Activitati.Activitati.DatePopulatieActivity;
import com.example.demografie.Activitati.Adaptoare.AdaptorPopulatie;
import com.example.demografie.Activitati.Clase.CSVMortalitatePeAni;
import com.example.demografie.Activitati.Clase.CSVNatalitatePeAni;
import com.example.demografie.Activitati.Clase.Populatie;
import com.example.demografie.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculIndicatoriFragment extends Fragment {

    View rootView;
    ListView listView;

    TextView tvVariatieGenerala;

    ArrayList<CSVNatalitatePeAni> listaNatalitate;
    ArrayList<CSVMortalitatePeAni> listaMortalitate;
    ArrayList<CSVMortalitatePeAni> listaEmigranti;
    ArrayList<CSVMortalitatePeAni> listaImigranti;
    ArrayList<CSVMortalitatePeAni> listaPopulatie;

    ArrayList<Integer> listaVariatieNaturala;
    ArrayList<Integer> listaVariatieMigratorie;
    ArrayList<Integer> listaVariatieGenerala;

    ArrayList<Populatie> listaCalculPopulatie;


    public CalculIndicatoriFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_calcul_indicatori, container, false);
        listaNatalitate= DateNatalitatePeAniActivity.preluareNatalitatePeAni(getActivity());
        listaMortalitate= DateMortalitatePeAniActivity.preluareMortalitatePeAni(getActivity());
        listaEmigranti= DateEmigrantiActivity.preluareEmigrantiPeAni(getActivity());
        listaImigranti= DateImigrantiActivity.preluareImigrantiPeAni(getActivity());
        listaPopulatie= DatePopulatieActivity.preluarePopulatie(getActivity());

        listaVariatieMigratorie=new ArrayList<>();
        listaVariatieNaturala=new ArrayList<>();
        listaVariatieGenerala=new ArrayList<>();

        listaCalculPopulatie=new ArrayList<>();


        for(int i=1;i<listaNatalitate.size();i++) {
            int variatieNaturala=0;
            variatieNaturala += listaNatalitate.get(i).getValoare();
            variatieNaturala -= listaMortalitate.get(i).getValoare();
            listaVariatieNaturala.add(variatieNaturala);
        }


        for(int i=0;i<listaImigranti.size()-1;i++)
        {
            int variatieMigratorie=0;
            variatieMigratorie+=listaImigranti.get(i).getValoare();
            variatieMigratorie-=listaEmigranti.get(i+1).getValoare();
            listaVariatieMigratorie.add(variatieMigratorie);
        }

        for(int i=0;i<listaVariatieMigratorie.size();i++)
            listaVariatieGenerala.add(listaVariatieMigratorie.get(i)+listaVariatieNaturala.get(i));

        int an=1993;
        for(int i=1;i<listaVariatieGenerala.size();i++) {
            listaCalculPopulatie.add(new Populatie(an, listaPopulatie.get(i).getValoare(), listaPopulatie.get(i).getValoare() + listaVariatieGenerala.get(i), listaVariatieMigratorie.get(i), listaVariatieNaturala.get(i)));
            an++;
        }


        listView=(ListView)rootView.findViewById(R.id.lvPopulatie);
        AdaptorPopulatie adaptor=new AdaptorPopulatie(getActivity(),listaCalculPopulatie);
        listView.setAdapter(adaptor);




        return rootView;
    }

}
