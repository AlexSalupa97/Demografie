package com.example.demografie.Activitati.Clase;

import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Grafice {

    public String titlu;
    public LineGraphSeries<DataPoint> series;

    public Grafice(String titlu, LineGraphSeries<DataPoint> series) {
        this.titlu = titlu;
        this.series = series;
    }

    public Grafice() {
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public LineGraphSeries<DataPoint> getSeries() {
        return series;
    }

    public void setSeries(LineGraphSeries<DataPoint> series) {
        this.series = series;
    }
}
