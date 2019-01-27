package com.example.demografie.Activitati.Activitati;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.example.demografie.Activitati.AdaptoareFragmente.AdaptorFragmente;
import com.example.demografie.R;

public class VizualizareFragmenteActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vizualizare_fragmente);

        actionBar=getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C5A80")));

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        AdaptorFragmente adapter = new AdaptorFragmente(getApplicationContext(), getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
