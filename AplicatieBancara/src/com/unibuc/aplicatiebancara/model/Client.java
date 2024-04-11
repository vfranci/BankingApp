package com.unibuc.aplicatiebancara.model;

import java.util.ArrayList;
import java.util.List;

public class Client /*implements AutentificareClient*/{
    private int id;
    private String nume;
    private String email;
    private String numarTelefon;
//    private String username;
//    private String parola;
    private List<ContBancar> conturi;

    public Client(int id, String nume, String email, String numarTelefon /*String username, String parola*/) {
        this.id = id;
        this.nume = nume;
        this.email = email;
        this.numarTelefon = numarTelefon;
        //this.username = username;
        //this.parola = parola;
        this.conturi = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getParola() {
//        return parola;
//    }
//
//    public void setParola(String parola) {
//        this.parola = parola;
//    }
//
//    @Override
//    public boolean autentificare(String username, String parola) {
//        return this.username.equals(username) && this.parola.equals(parola);
//    }

//    @Override
//    public void deconectare() {}
    public void adaugaCont(ContBancar cont) {
        conturi.add(cont);
    }

    public List<ContBancar> getConturi() {
        return conturi;
    }

    public void stergeCont(ContBancar cont) {
        conturi.remove(cont);
    }

    public void afiseazaConturi(){
        System.out.println("\nConturile clientului " + this.nume + ": ");
        for (ContBancar c : conturi){
            System.out.println(c.getIban());
        }

    }

}
