package com.unibuc.aplicatiebancara.model;

public interface AutentificareClient {
    boolean autentificare(String username, String parola);
    void deconectare();
}
