package com.unibuc.aplicatiebancara;

import com.unibuc.aplicatiebancara.exceptii.DuplicatException;
import com.unibuc.aplicatiebancara.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AppStartup {
    public static void main(String[] args) throws DuplicatException {

        // Demonstrarea tipurilor de transfer
        
        ContBancar contRON1 = new ContRON("RO0123", 100);
        Date dataCurenta = new Date();

        System.out.println("Soldul initial pentru contul" + contRON1.getIban() + ": " + contRON1.getSold());
        
        ITranzactie depunere = new Depunere(200, contRON1, dataCurenta);
        depunere.executa();
        
        ITranzactie retragere = new Retragere(500, contRON1, dataCurenta);
        retragere.executa();
        
        ContBancar contEUR1 = new ContEUR("RO4567", 500);
        ITranzactie transfer = new Transfer(300, contRON1, contEUR1, dataCurenta);
        transfer.executa();
        
        contRON1.afiseazaExtrasDeCont();
        contEUR1.afiseazaExtrasDeCont();

        // Asocierea unui card cu un cont

        contRON1.adaugaCardBancar("1234567890123456", "12/25", TipCard.DEBIT, "123");
        contRON1.afiseazaDetaliiCard();

        // Sortarea conturilor dupa suma

        ContBancar contEUR2 = new ContEUR("RO8910", 4);
        ContBancar contEUR3 = new ContEUR("RO1112", 100);

        ContBancar contRON2 = new ContRON("RO1314", 1605);
        ContBancar contRON3 = new ContRON("RO1516", 100);

        List<ContBancar> conturi = new ArrayList<>();
        conturi.add(contRON1);
        conturi.add(contRON2);
        conturi.add(contRON3);
        conturi.add(contEUR1);
        conturi.add(contEUR2);
        conturi.add(contEUR3);
        List<ContBancar> conturiRON = new ArrayList<>();
        List<ContBancar> conturiEUR = new ArrayList<>();

        for (ContBancar cont : conturi) {
            if (cont instanceof ContRON) {
                conturiRON.add(cont);
            } else if (cont instanceof ContEUR) {
                conturiEUR.add(cont);
            }
        }

        Collections.sort(conturiRON, (cont1, cont2) -> Double.compare(cont1.getSold(), cont2.getSold()));
        Collections.sort(conturiEUR, (cont1, cont2) -> Double.compare(cont1.getSold(), cont2.getSold()));

        System.out.println("\nConturi RON:");
        for (ContBancar cont : conturiRON) {
            System.out.println("IBAN: " + cont.getIban() + ", Sold: " + cont.getSold());
        }

        System.out.println("\nConturi EUR:");
        for (ContBancar cont : conturiEUR) {
            System.out.println("IBAN: " + cont.getIban() + ", Sold: " + cont.getSold());
        }

        Client c1 = new Client(1, "Andreea Marinescu", "andreea_m@gmail.com", "0722000000");
        c1.adaugaCont(contEUR1);
        c1.adaugaCont(contRON1);

        c1.afiseazaConturi();
    }
}


