package com.unibuc.aplicatiebancara.model;

import com.unibuc.aplicatiebancara.exceptii.DuplicatException;
import com.unibuc.aplicatiebancara.model.ContBancar;

public class ContEconomii extends ContBancar {
    private final double rataDobandaAnuala = 4.5;

    public ContEconomii(String numarCont, double sold, double rataDobandaAnuala) throws DuplicatException {
        super(numarCont, sold);
    }

    public void aplicaDobandaAnuala() {
        double dobandaAnuala = calculeazaDobandaAnuala();
        setSold(calculeazaDobandaAnuala());
    }

    private double calculeazaDobandaAnuala() {
        return getSold() * (rataDobandaAnuala / 100);
    }
}
