package com.example.demografie.Activitati.Clase;

public class CSVMortalitatePeAni {

    private int an;
    private int valoare;

    public CSVMortalitatePeAni(int an, int valoare) {
        this.an = an;
        this.valoare = valoare;
    }

    public CSVMortalitatePeAni() {
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
