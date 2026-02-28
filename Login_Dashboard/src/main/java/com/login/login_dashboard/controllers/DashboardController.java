package com.login.login_dashboard.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Controlador del dashboard.
 * Gestiona la vista principal tras el inicio de sesión,
 * mostrando un mensaje de bienvenida y permitiendo salir
 * de nuevo a la pantalla de login.
 */
public class DashboardController {

    /** Etiqueta utilizada para mostrar el mensaje de bienvenida al usuario. */
    @FXML
    private Label lblBienvenido;

    /**
     * Establece el nombre del usuario en la etiqueta de bienvenida.
     * @param usuario Nombre del usuario autenticado.
     */
    public void setUsuario(String usuario) {
        lblBienvenido.setText("Bienvenido: " + usuario+ " :)");
    }

    /**
     * Metodo Salir
     * Regresa a la vista de login cargando el archivo FXML correspondiente.
     * Reemplaza la escena actual con la de login y muestra la ventana actualizada.
     * @param event Evento de acción que dispara el metodo.
     */
    public void Salir(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/login/login_dashboard/login-view.fxml"));
            Scene loginScene = new Scene(loader.load(), 500, 400);

            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(loginScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
