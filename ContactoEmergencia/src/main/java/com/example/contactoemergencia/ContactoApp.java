package com.example.contactoemergencia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Aplicación principal para la gestión de contactos de emergencia.
 * Carga la interfaz definida en el archivo FXML y muestra la ventana principal.
 */
public class ContactoApp extends Application {

    /**
     * Inicia la aplicación JavaFX.
     * Configura la ventana principal y carga la interfaz desde el archivo FXML.
     * @param primaryStage escenario principal de la aplicación
     * @throws Exception si ocurre un error al cargar el archivo FXML
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("contacto.fxml"));
        primaryStage.setTitle("Gestión de Contactos de Emergencia");
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();
    }

    /**
     * Metodo principal de la aplicación.
     * Lanza la ejecución de la aplicación JavaFX.
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        launch(args);
    }
}