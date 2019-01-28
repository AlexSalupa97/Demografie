package com.example.demografie.Activitati.Fragmente;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.demografie.Activitati.Activitati.DateNatalitatePeAniActivity;
import com.example.demografie.Activitati.Activitati.DateNatalitatePeJudeteActivity;
import com.example.demografie.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VizualizareDateFragment extends Fragment {

    Button btnNatalitate;
    Button btnNatalitatePeAni;
    View rootView;

    public VizualizareDateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_vizualizare_date, container, false);

        btnNatalitate=(Button)rootView.findViewById(R.id.btnNatalitate);
        btnNatalitate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), DateNatalitatePeJudeteActivity.class);
                startActivity(intent);
            }
        });

        btnNatalitatePeAni=(Button)rootView.findViewById(R.id.btnNatalitatePeAni);
        btnNatalitatePeAni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), DateNatalitatePeAniActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}

