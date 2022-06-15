package com.example.dictionary;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;


public class DictionaryApplication extends Application {
    static DictionaryManagement management = new DictionaryManagement();

    @Override
    public void start( Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(DictionaryApplication.class.getResource("DisplayFxlm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Tu Dien Anh-Viet");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        management.insertFromFile();
        launch(args);
    }

}
