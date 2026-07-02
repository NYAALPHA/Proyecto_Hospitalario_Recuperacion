package com.elsilencio.software_hotel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"));
        stage.setTitle("Hotel - Sistema de Gestion");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        Image icono = new Image(getClass().getResourceAsStream("/com/elsilencio/software_hotel/imagenes/logo.png"));
        stage.getIcons().add(icono);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        String ruta = "/com/elsilencio/software_hotel/fxml/" + fxml + ".fxml";
        System.out.println("Cargando: " + ruta);  // Para verificar la ruta
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(ruta));
        
        if (fxmlLoader.getLocation() == null) {
            throw new IOException("No se encuentra el archivo: " + ruta);
        }
        
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}