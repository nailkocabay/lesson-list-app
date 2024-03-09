package com.example.nyp2612231;

public class Ders {
    private String dersAdi;
    private int KisiSayisi;
    private int gecenKisiSayisi;
    private int kalanKisiSayisi;

    public Ders(String dersAdi,int KisiSayisi, int gecenKisiSayisi, int kalanKisiSayisi) {
        this.dersAdi = dersAdi;
        this.KisiSayisi = KisiSayisi;
        this.gecenKisiSayisi = gecenKisiSayisi;
        this.kalanKisiSayisi = kalanKisiSayisi;
    }

    public String getDersAdi() {
        return dersAdi;
    }
    public int getKisiSayisi(){
        return KisiSayisi;
    }

    public int getGecenKisiSayisi() {
        return gecenKisiSayisi;
    }

    public int getKalanKisiSayisi() {
        return kalanKisiSayisi;
    }

}