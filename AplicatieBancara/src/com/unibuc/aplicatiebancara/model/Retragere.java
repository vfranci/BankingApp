package com.unibuc.aplicatiebancara.model;

import com.unibuc.aplicatiebancara.exceptii.FonduriInsuficienteException;

import java.util.Date;

public class Retragere implements ITranzactie {
    private double suma;
    private ContBancar cont;
    private Date data;

    public Retragere(double suma, ContBancar cont, Date dataCurenta) {
        this.suma = suma;
        this.cont = cont;
        this.data = dataCurenta;
    }

    @Override
    public void executa() {
        try {
            cont.retrageSuma(suma);
            suma = -suma;
            cont.adaugaTranzactie(new Tranzactie(suma, TipTranzactie.RETRAGERE, data));
        } catch (FonduriInsuficienteException e) {
            System.out.println("Nu există suficiente fonduri în cont pentru a efectua retragerea.");
        }
    }


    @Override
    public TipTranzactie getTip() {
        return TipTranzactie.RETRAGERE;
    }
}
