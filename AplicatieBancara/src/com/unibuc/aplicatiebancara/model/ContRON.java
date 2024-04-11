package com.unibuc.aplicatiebancara.model;

import com.unibuc.aplicatiebancara.exceptii.DuplicatException;
import com.unibuc.aplicatiebancara.model.ContBancar;

public class ContRON extends ContBancar {
    private double plafonDeCredit;

    public ContRON(String iban, double sold, double plafonDeCredit) throws DuplicatException {
        super(iban, sold);
        this.plafonDeCredit = plafonDeCredit;
    }

    public ContRON(String iban, double sold) throws DuplicatException {
        super(iban, sold);
    }


}
