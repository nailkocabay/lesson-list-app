package com.example.nyp2612231;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Lise extends Ders {
    public static ObservableList<Ders> liseDersListesi = FXCollections.observableArrayList();


    public Lise(String dersAdi, int KisiSayisi, int gecenKisiSayisi, int kalanKisiSayisi) {
        super(dersAdi, KisiSayisi, gecenKisiSayisi, kalanKisiSayisi);
    }
}