package com.example.demografie.Activitati;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.demografie.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_splashscreen);

        Thread t = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    sleep(3000);
                }
                catch (InterruptedException e) {
                    Log.e("SplashScreen",e.getMessage());
                }
                finally {
                    Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent1);
                    finish();
                }
            }
        };
        t.start();

    }
}
