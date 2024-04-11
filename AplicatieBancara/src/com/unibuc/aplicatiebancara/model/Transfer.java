package com.unibuc.aplicatiebancara.model;

import com.unibuc.aplicatiebancara.exceptii.FonduriInsuficienteException;

import java.util.Date;

public class Transfer implements ITranzactie {
    private double suma;
    private final ContBancar sursa;
    private final ContBancar destinatie;
    private final Date data;

    public Transfer(double suma, ContBancar sursa, ContBancar destinatie, Date dataCurenta) {
        this.suma = suma;
        this.sursa = sursa;
        this.destinatie = destinatie;
        this.data = dataCurenta;
    }

    @Override
    public void executa() {
        try {
            //fac retragerea sumei, deoarece retrag EUR din sursa
            sursa.retrageSuma(suma);
            // pun minus la suma pentru a exemplifica retragerea din contul sursa si
            // adaug tranzactia in lista de tranzactii a contului sursa, tot in moneda EUR
            suma = -suma;
            sursa.adaugaTranzactie(new Tranzactie(suma, TipTranzactie.TRANSFER, data));
            // refac iar suma cu semnul pozitiv
            suma = -suma;
            if(sursa instanceof ContEUR && destinatie instanceof ContRON) {
                // fac conversia la ron
                suma = suma * 4.96 - sursa.calculeazaComision();
            }
            if(sursa instanceof ContRON && destinatie instanceof ContEUR) {
                suma = suma / 4.96 - destinatie.calculeazaComision();
            }
            destinatie.adaugaSuma(suma);
            destinatie.adaugaTranzactie(new Tranzactie(suma, TipTranzactie.TRANSFER, data));
        } catch (FonduriInsuficienteException e) {
            System.out.println("\nNu există suficiente fonduri în contul sursă pentru a efectua transferul.");
        }
    }


    @Override
    public TipTranzactie getTip() {
        return TipTranzactie.TRANSFER;
    }
}

