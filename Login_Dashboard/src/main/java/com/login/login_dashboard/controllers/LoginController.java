package com.login.login_dashboard.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador de la vista de login.
 * Gestiona la validación de credenciales y la transición
 * hacia el dashboard en caso de éxito.
 */
public class LoginController {

    /** Campo de texto para ingresar el nombre de usuario. */
    @FXML
    private TextField TxtUsuario;

    /** Campo de texto para ingresar el correo electrónico. */
    @FXML
    private TextField TxtCorreo;

    /** Campo de contraseña para ingresar la clave de acceso. */
    @FXML
    private PasswordField TxtPassword;

    /** Campo de texto utilizado para mostrar mensajes de error. */
    @FXML
    private TextField lblError;

    /**
     * Metodo Entrar
     * Válida los datos ingresados (usuario, correo y contraseña).
     * Si son correctos, carga la vista del dashboard;
     * en caso contrario, muestra los errores en la interfaz.
     *
     * @param event Evento de acción que dispara el metodo.
     */
    public void Entrar(ActionEvent event) {
        String usuario  = TxtUsuario.getText()  == null ? "" : TxtUsuario.getText();
        String correo   = TxtCorreo.getText()   == null ? "" : TxtCorreo.getText();
        String password = TxtPassword.getText() == null ? "" : TxtPassword.getText();

        List<String> errores = new ArrayList<>();


        if (usuario.trim().isEmpty() || usuario.length() < 4) {
            errores.add("Usuario inválido (mínimo 4 caracteres)");
        }

        if (correo.trim().isEmpty() || !correo.contains("@") || !correo.contains(".")) {
            errores.add("Correo inválido (debe incluir @ y .) ");
        }
        if (password.isEmpty() || password.length() < 6) {
            errores.add("Contraseña inválida (minimo 6 caracteres). ");
        }

        if (errores.isEmpty()) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/login/login_dashboard/dashboard-view.fxml"));
                Scene dashboardScene = new Scene(loader.load(), 500, 400);


                DashboardController dashboardController = loader.getController();
                dashboardController.setUsuario(usuario);

                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(dashboardScene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String mensajeError = "";
            for (String error : errores) {
                mensajeError += error;
            }
            lblError.setText(mensajeError);
            lblError.setStyle("-fx-border-color: red; -fx-text-fill: red;");
        }
    }
}
