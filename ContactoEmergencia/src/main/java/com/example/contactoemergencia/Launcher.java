package com.example.contactoemergencia;

import javafx.application.Application;

/**
 * Clase de inicio de la aplicación.
 * Se encarga de lanzar la ejecución de la aplicación JavaFX {@link ContactoApp}.
 */
public class Launcher {

    /**
     * Metodo principal de la aplicación.
     * Llama al metodo {@link Application#launch} para iniciar la aplicación JavaFX.
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        Application.launch(ContactoApp.class, args);
    }
}