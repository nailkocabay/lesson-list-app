package com.example.nyp2612231;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Ilkokul extends Ders {
    public static ObservableList<Ders> ilkokulDersListesi = FXCollections.observableArrayList();

    public Ilkokul(String dersAdi, int KisiSayisi, int gecenKisiSayisi, int kalanKisiSayisi) {
        super(dersAdi, KisiSayisi, gecenKisiSayisi, kalanKisiSayisi);
    }






}


