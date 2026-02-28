package com.login.login_dashboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Clase principal de la aplicación LoginDashboard.
 * -------------------------
 * Extiende {@link javafx.application.Application} y sirve como punto de entrada
 * para inicializar la interfaz gráfica de login.
 */
public class LoginDashboard extends Application {

    /**
     * Metodo start
     * Carga la vista de login desde el archivo FXML y la muestra en una ventana
     * con dimensiones específicas (500x450).
     * @param stage Ventana principal de la aplicación.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginDashboard.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 450);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
}
