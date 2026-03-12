package com.example.demolistview;

import javafx.application.Application;

/**
 * Clase principal que inicia la aplicación JavaFX.
 * Utiliza {@link Application#launch(Class, String...)} para delegar
 * la ejecución en la clase {@link Main}.
 */

public class Launcher {
    /**
     * Metodo de entrada de la aplicación.
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {

        Application.launch(Main.class, args);
    }
}
