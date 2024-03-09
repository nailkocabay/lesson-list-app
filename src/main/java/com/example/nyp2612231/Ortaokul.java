package com.example.nyp2612231;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Ortaokul extends Ders{

    public static ObservableList<Ders> ortaokulDersListesi = FXCollections.observableArrayList();
    public Ortaokul(String dersAdi, int KisiSayisi, int gecenKisiSayisi, int kalanKisiSayisi) {
        super(dersAdi, KisiSayisi, gecenKisiSayisi, kalanKisiSayisi);

    }


}