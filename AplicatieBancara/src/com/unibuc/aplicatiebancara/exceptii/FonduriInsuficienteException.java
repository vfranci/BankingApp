package com.unibuc.aplicatiebancara.exceptii;

public class FonduriInsuficienteException extends Exception {
    public FonduriInsuficienteException() {
        super("Fonduri insuficiente pentru retragere!");
    }
    public FonduriInsuficienteException(String mesaj) {
        super(mesaj);
    }
}
