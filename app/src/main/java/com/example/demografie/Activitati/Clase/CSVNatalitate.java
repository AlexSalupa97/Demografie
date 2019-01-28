package com.example.demografie.Activitati.Clase;

import com.opencsv.bean.CsvBindByPosition;

public class CSVNatalitate {

    @CsvBindByPosition(position = 0)
    private String judet;

    @CsvBindByPosition(position = 1)
    private int numarNouNascuti1960;

    @CsvBindByPosition(position = 2)
    private int numarNouNascuti2016;

    public CSVNatalitate(String judet, int numarNouNascuti1960, int numarNouNascuti2016) {
        this.judet = judet;
        this.numarNouNascuti1960 = numarNouNascuti1960;
        this.numarNouNascuti2016 = numarNouNascuti2016;
    }

    public CSVNatalitate() {
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public int getNumarNouNascuti1960() {
        return numarNouNascuti1960;
    }

    public void setNumarNouNascuti1960(int numarNouNascuti1960) {
        this.numarNouNascuti1960 = numarNouNascuti1960;
    }

    public int getNumarNouNascuti2016() {
        return numarNouNascuti2016;
    }

    public void setNumarNouNascuti2016(int numarNouNascuti2016) {
        this.numarNouNascuti2016 = numarNouNascuti2016;
    }
}