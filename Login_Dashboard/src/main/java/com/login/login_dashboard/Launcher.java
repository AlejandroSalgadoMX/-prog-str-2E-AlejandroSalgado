package com.login.login_dashboard;
import javafx.application.Application;

/**
 * Clase Launcher
 * Punto de entrada principal de la aplicación.
 * Lanza la aplicación JavaFX utilizando la clase {@link LoginDashboard}.
 */
public class Launcher {

    /**
     * Metodo main
     * Inicia la aplicación JavaFX llamando a {@link Application#launch}.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        Application.launch(LoginDashboard.class, args);
    }
}
