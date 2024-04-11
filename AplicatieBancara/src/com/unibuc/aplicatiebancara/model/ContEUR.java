package com.unibuc.aplicatiebancara.model;

import com.unibuc.aplicatiebancara.exceptii.DuplicatException;
import com.unibuc.aplicatiebancara.model.ContBancar;

public class ContEUR extends ContBancar {
    private double comisionSchimbareValuta = 5;
    public ContEUR(String iban, double sold) throws DuplicatException {
        super(iban, sold);
        //this.comisionSchimbareValuta = comisionSchimbareValuta;
    }

    @Override
    public double calculeazaComision() { return (getSold() * comisionSchimbareValuta)/100; }
}
