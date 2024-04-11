package com.unibuc.aplicatiebancara.model;

import com.unibuc.aplicatiebancara.model.TipTranzactie;

import java.util.Date;

public class Tranzactie {
    // private int id;
    private double suma;
    private TipTranzactie tip;
    private Date data;

    public Tranzactie(double suma, TipTranzactie tip, Date data) {
        //this.id = id;
        this.suma = suma;
        this.tip = tip;
        this.data = data;
    }

    public Tranzactie() {
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public TipTranzactie getTip() {
        return tip;
    }

    public void setTip(TipTranzactie tip) {
        this.tip = tip;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        if(suma > 0) {
            return "Tranzactie{" +
                    "suma = +" + suma +
                    ", tip = " + tip +
                    ", data = '" + data + '\'' +
                    '}';
        } else {
            return "Tranzactie{" +
                    "suma = " + suma +
                    ", tip = " + tip +
                    ", data = '" + data + '\'' +
                    '}';
        }

    }
}
