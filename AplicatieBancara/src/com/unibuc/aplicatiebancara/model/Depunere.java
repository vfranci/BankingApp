package com.unibuc.aplicatiebancara.model;

import java.util.Date;

public class Depunere implements ITranzactie {
    private double suma;
    private ContBancar cont;
    private Date data;

    public Depunere(double suma, ContBancar cont, Date data) {
        this.suma = suma;
        this.cont = cont;
        this.data = data;
    }

    @Override
    public void executa() {
        cont.adaugaSuma(suma);
        cont.adaugaTranzactie(new Tranzactie(suma, TipTranzactie.DEPUNERE, data));
    }

    @Override
    public TipTranzactie getTip() {
        return TipTranzactie.DEPUNERE;
    }
}
