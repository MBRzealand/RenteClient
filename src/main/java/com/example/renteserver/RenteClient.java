package com.example.renteserver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RenteClient extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RenteClient.class.getResource("renteclient-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 380, 220);
        stage.setTitle("Renteserver Client");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}