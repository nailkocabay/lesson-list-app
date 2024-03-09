package com.example.nyp2612231;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class DersEkle extends Application {
    @FXML
    TextField textFieldDersAdi;
    @FXML
    TextField textFieldGecenKisiSayisi;
    @FXML
    TextField textFieldKalanKisiSayisi;
    @FXML
    Button dersEkleButton;
    @FXML
    Button kaydetButton;
    @FXML
    TableView<Ders> ilkokulTableView;
    @FXML
    TableColumn<Ders,String> ilkokulDersAdi;
    @FXML
    TableColumn<Ders,String> ilkokulKisiSayisi;
    @FXML
    TableColumn<Ders,Integer> ilkokulGecenSayisi;
    @FXML
    TableColumn<Ders,Integer> ilkokulKalanSayisi;
    @FXML
    TableView<Ders> ortaokulTableView;
    @FXML
    TableColumn<Ders,String> ortaokulDersAdi;
    @FXML
    TableColumn<Ders,Integer> ortaokulKisiSayisi;
    @FXML
    TableColumn<Ders,Integer> ortaokulGecenSayisi;
    @FXML
    TableColumn<Ders,Integer> ortaokulKalanSayisi;
    @FXML
    TableView<Ders> liseTableView;
    @FXML
    TableColumn<Ders,String> liseDersAdi;
    @FXML
    TableColumn<Ders,Integer> liseKisiSayisi;
    @FXML
    TableColumn<Ders,Integer> liseGecenSayisi;
    @FXML
    TableColumn<Ders,Integer> liseKalanSayisi;
    @FXML
    ComboBox comboBox;







    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DersEkle.class.getResource("nypProje.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1000,450);
        primaryStage.setTitle("Ders Ekleme Ekranı");

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    
    public void buton(){
        {
            ObservableList<Ders> DersListesi = FXCollections.observableArrayList();
            String dersAdi =   textFieldDersAdi.getText();

            String gecenKisiSayisiStr = textFieldGecenKisiSayisi.getText();
            String kalanKisiSayisiStr = textFieldKalanKisiSayisi.getText();

            //İlkokul Sütunlarını Doldurma İşlemi
            ilkokulDersAdi.setCellValueFactory(new PropertyValueFactory<>("dersAdi"));
            ilkokulKisiSayisi.setCellValueFactory(new PropertyValueFactory<>("KisiSayisi"));
            ilkokulGecenSayisi.setCellValueFactory(new PropertyValueFactory<>("gecenKisiSayisi"));
            ilkokulKalanSayisi.setCellValueFactory(new PropertyValueFactory<>("kalanKisiSayisi"));

            //Ortaokul Sütunlarını Doldurma İşlemi
            ortaokulDersAdi.setCellValueFactory(new PropertyValueFactory<>("dersAdi"));
            ortaokulKisiSayisi.setCellValueFactory(new PropertyValueFactory<>("KisiSayisi"));
            ortaokulGecenSayisi.setCellValueFactory(new PropertyValueFactory<>("gecenKisiSayisi"));
            ortaokulKalanSayisi.setCellValueFactory(new PropertyValueFactory<>("kalanKisiSayisi"));

            //Lise Sütunlarını Doldurma İşlemi
            liseDersAdi.setCellValueFactory(new PropertyValueFactory<>("dersAdi"));
            liseKisiSayisi.setCellValueFactory(new PropertyValueFactory<>("KisiSayisi"));
            liseGecenSayisi.setCellValueFactory(new PropertyValueFactory<>("gecenKisiSayisi"));
            liseKalanSayisi.setCellValueFactory(new PropertyValueFactory<>("kalanKisiSayisi"));

            try {
                int gecenKisiSayisi = Integer.parseInt(gecenKisiSayisiStr);
                int kalanKisiSayisi = Integer.parseInt(kalanKisiSayisiStr);
                int KisiSayisi = gecenKisiSayisi + kalanKisiSayisi;

                String selectedLevel = (String) comboBox.getValue();

                if (selectedLevel != null) {
                    Ders yeniDers = new Ders(dersAdi, KisiSayisi, gecenKisiSayisi, kalanKisiSayisi) ;
                    DersListesi.add(yeniDers);
                    switch (selectedLevel) {
                        case "Ilkokul":
                            ilkokulTableView.getItems().addAll(DersListesi);
                            Ilkokul.ilkokulDersListesi.add(yeniDers);
                            DosyayaKaydet.saveToFile(dersAdi,gecenKisiSayisi,kalanKisiSayisi,KisiSayisi);
                            break;
                        case "Ortaokul":
                            ortaokulTableView.getItems().addAll(DersListesi);
                            Ortaokul.ortaokulDersListesi.add(yeniDers);
                            DosyayaKaydet.saveToFile(dersAdi,gecenKisiSayisi,kalanKisiSayisi,KisiSayisi);
                            break;
                        case "Lise":
                            liseTableView.getItems().addAll(DersListesi);
                            Lise.liseDersListesi.add(yeniDers);
                            DosyayaKaydet.saveToFile(dersAdi,gecenKisiSayisi,kalanKisiSayisi,KisiSayisi);

                            break;
                    }
                } else {
                    Uyarilar.showAlert("Hata", "Lütfen bir öğrenim düzeyi seçin.");
                }
            } catch (NumberFormatException ex) {
                Uyarilar.showAlert("Hata", "Hatalı sayı formatı. Lütfen doğru sayıları girin.");
            }
        }
    }

}


