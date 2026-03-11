package com.example.demolistview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Clase principal de la aplicación JavaFX.
 * Extiende {@link Application} y define el metodo {@code start} que
 * carga la interfaz desde un archivo FXML y muestra la ventana principal.
 */

public class Main extends Application {

    /**
     * Inicializa y muestra la ventana principal de la aplicación.
     * @param stage Ventana principal de JavaFX
     * @throws IOException Si ocurre un error al cargar el archivo FXML
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/example/demolistview/views/app-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("ListView");
        stage.setScene(scene);
        stage.show();
    }
}
