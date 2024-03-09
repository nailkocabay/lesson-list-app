package com.example.nyp2612231;

import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DosyayaKaydet {
//    public static void saveToFile(String text1, int text2, int text3, int text4) {
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Dosyayı Kaydet");
//        File file = fileChooser.showSaveDialog(null);
//
//        if (file != null) {
//            try (FileWriter fileWriter = new FileWriter(file,true)) {
//                // Metinleri dosyaya sütun olarak yaz
//                fileWriter.write("\nDers Adı\t\tGeçen Sayısı\t\tKalan Sayısı\t\tToplam Kişi Sayısı\n");
//                fileWriter.write("\n"+text1 + "\t\t\t" + text2 + "\t\t\t" + text3 + "\t\t\t" + text4 + "\n" );
//                System.out.println("Metinler dosyaya başarıyla kaydedildi.");
//            } catch (IOException e) {
//                System.err.println("Hata: Dosyaya yazma sırasında bir sorun oluştu.");
//                e.printStackTrace();
//            }
//        }
//    }

    private static File selectedFile;

    public static void saveToFile(String text1, int text2, int text3, int text4) {
        if (selectedFile == null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Dosyayı Kaydet");
            selectedFile = fileChooser.showSaveDialog(null);
        }

        if (selectedFile != null) {
            try (FileWriter fileWriter = new FileWriter(selectedFile, true)) {
                fileWriter.write("\nDers Adı\t\tGeçen Sayısı\t\tKalan Sayısı\t\tToplam Kişi Sayısı\n");
                fileWriter.write("\n" + text1 + "\t\t\t" + text2 + "\t\t\t" + text3 + "\t\t\t" + text4 + "\n");
                System.out.println("Metinler dosyaya başarıyla kaydedildi.");
            } catch (IOException e) {
                System.err.println("Hata: Dosyaya yazma sırasında bir sorun oluştu.");
                e.printStackTrace();
            }
        }
    }
}


