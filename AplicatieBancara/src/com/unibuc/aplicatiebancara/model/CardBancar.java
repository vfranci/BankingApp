package com.unibuc.aplicatiebancara.model;

public class CardBancar {
    private String numar;
    private String dataExpirare;
    private TipCard tip;
    private String cvv;

    public CardBancar(String numar, String dataExpirare, TipCard tip, String cvv) {
        this.numar = numar;
        this.dataExpirare = dataExpirare;
        this.tip = tip;
        this.cvv = cvv;
    }

    public CardBancar() {

    }

    public String getNumar() {
        return numar;
    }

    public void setNumar(String numar) {
        this.numar = numar;
    }

    public String getDataExpirare() {
        return dataExpirare;
    }

    public void setDataExpirare(String dataExpirare) {
        this.dataExpirare = dataExpirare;
    }

    public TipCard getTip() {
        return tip;
    }

    public void setTip(TipCard tip) {
        this.tip = tip;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

}
