package com.example.demografie.Activitati.Clase;

import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class GraficeBare {

    private String titlu;
    private BarGraphSeries<DataPoint> series;

    public GraficeBare(String titlu, BarGraphSeries<DataPoint> series) {
        this.titlu = titlu;
        this.series = series;
    }

    public GraficeBare() {
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public BarGraphSeries<DataPoint> getSeries() {
        return series;
    }

    public void setSeries(BarGraphSeries<DataPoint> series) {
        this.series = series;
    }
}
