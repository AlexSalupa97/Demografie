package com.example.demografie.Activitati.Clase;

public class Populatie {

    private int an;
    private int populatieDeclarata;
    private int populatieCalculata;
    private int variatieMigratoare;
    private int variatieNaturala;

    public Populatie(int an, int populatieDeclarata, int populatieCalculata, int variatieMigratoare, int variatieNaturala) {
        this.an = an;
        this.populatieDeclarata = populatieDeclarata;
        this.populatieCalculata = populatieCalculata;
        this.variatieMigratoare = variatieMigratoare;
        this.variatieNaturala = variatieNaturala;
    }

    public Populatie() {
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public int getPopulatieDeclarata() {
        return populatieDeclarata;
    }

    public void setPopulatieDeclarata(int populatieDeclarata) {
        this.populatieDeclarata = populatieDeclarata;
    }

    public int getPopulatieCalculata() {
        return populatieCalculata;
    }

    public void setPopulatieCalculata(int populatieCalculata) {
        this.populatieCalculata = populatieCalculata;
    }

    public int getVariatieMigratoare() {
        return variatieMigratoare;
    }

    public void setVariatieMigratoare(int variatieMigratoare) {
        this.variatieMigratoare = variatieMigratoare;
    }

    public int getVariatieNaturala() {
        return variatieNaturala;
    }

    public void setVariatieNaturala(int variatieNaturala) {
        this.variatieNaturala = variatieNaturala;
    }
}
