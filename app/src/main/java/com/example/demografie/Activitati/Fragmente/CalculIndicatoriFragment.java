package com.example.demografie.Activitati.Fragmente;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demografie.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculIndicatoriFragment extends Fragment {

    View rootView;

    public CalculIndicatoriFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_calcul_indicatori, container, false);
        return rootView;
    }

}
