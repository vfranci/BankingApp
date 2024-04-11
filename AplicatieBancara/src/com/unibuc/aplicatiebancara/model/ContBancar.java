package com.unibuc.aplicatiebancara.model;

import com.unibuc.aplicatiebancara.exceptii.DuplicatException;
import com.unibuc.aplicatiebancara.exceptii.FonduriInsuficienteException;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public abstract class ContBancar {
    protected static Set<String> ibanuriExistente = new HashSet<>();
    protected static Set<String> numereCarduriExistente = new HashSet<>();
    protected String iban;
    protected double sold;
    protected List<Tranzactie> tranzactii;
    protected CardBancar card;

    public ContBancar(String iban, double sold) throws DuplicatException {
        if (ibanuriExistente.contains(iban)) {
            throw new DuplicatException("IBAN-ul este deja utilizat.");
        }
        this.iban = iban;
        this.sold = sold;
        this.card = new CardBancar();
        this.tranzactii = new ArrayList<>();

        // Adaugă IBAN-ul contului în setul de IBAN-uri existente
        ibanuriExistente.add(iban);
    }

    public ContBancar() {
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public void adaugaTranzactie(Tranzactie tranzactie) {
        tranzactii.add(tranzactie);
    }

    public List<Tranzactie> getTranzactii() {
        return tranzactii;
    }

    public void adaugaSuma(double suma) {
        sold += suma;
    }

    public void retrageSuma(double suma) throws FonduriInsuficienteException {
        if (this.sold < suma) {
            throw new FonduriInsuficienteException("Fonduri insuficiente pentru retragere!");
        }
        this.sold -= suma;
    }

    public void afiseazaExtrasDeCont(){
        System.out.println("\nExtras de cont pentru contul " + iban + ":");
        System.out.println("Tranzactii efectuate:");
        for (Tranzactie tranzactie : tranzactii) {
            System.out.println(tranzactie);
        }
        System.out.println("Sold curent: " + sold);
    }

    public void adaugaCardBancar(String numar, String dataExpirare, TipCard tip, String cvv) throws DuplicatException {
        if (numereCarduriExistente.contains(numar)) {
            throw new DuplicatException("\nNumărul de card bancar este deja utilizat.");
        }
        this.card = new CardBancar(numar, dataExpirare, tip, cvv);
        numereCarduriExistente.add(numar);
    }

    public void afiseazaDetaliiCard() {
        if (card != null) {
            System.out.println("\nNumăr card: " + card.getNumar());
            System.out.println("Data expirare: " + card.getDataExpirare());
            System.out.println("Tip card: " + card.getTip());
            System.out.println("CVV: " + card.getCvv());
        } else {
            System.out.println("Contul nu are un card asociat.");
        }
    }

    public double calculeazaComision(){ return 0;}
}
