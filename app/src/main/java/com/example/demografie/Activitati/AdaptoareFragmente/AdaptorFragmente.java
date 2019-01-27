package com.example.demografie.Activitati.AdaptoareFragmente;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.demografie.Activitati.Fragmente.CalculIndicatoriFragment;
import com.example.demografie.Activitati.Fragmente.GraficeFragment;
import com.example.demografie.Activitati.Fragmente.VizualizareDateFragment;


public class AdaptorFragmente extends FragmentPagerAdapter {
    private Context mContext;

    public AdaptorFragmente(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return "Grafice";
        else if (position == 1)
            return "Vizualizare date";
        else
            return "Calcul indicatori";
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new GraficeFragment();
        else if (position == 1)
            return new VizualizareDateFragment();
        else
            return new CalculIndicatoriFragment();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
