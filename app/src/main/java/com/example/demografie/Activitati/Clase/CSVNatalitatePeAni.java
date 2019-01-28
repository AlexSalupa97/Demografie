package com.example.demografie.Activitati.Clase;

public class CSVNatalitatePeAni {

    private int an;
    private int valoare;

    public CSVNatalitatePeAni(int an, int valoare) {
        this.an = an;
        this.valoare = valoare;
    }

    public CSVNatalitatePeAni() {
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public int getValoare() {
        return valoare;
    }

    public void setValoare(int valoare) {
        this.valoare = valoare;
    }
}
