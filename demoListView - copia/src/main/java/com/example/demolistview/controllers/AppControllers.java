package com.example.demolistview.controllers;

import com.example.demolistview.services.PersonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

/**
 * Controlador principal de la aplicación.
 * Maneja la interacción entre la interfaz gráfica (FXML) y la lógica
 * de negocio definida en {@link PersonService}.
 */
public class AppControllers {

    /** Etiqueta para mostrar mensajes al usuario */
    @FXML
    private Label lblMsg;

    /** Lista visual que muestra los datos cargados */
    @FXML
    private ListView<String> listView;

    /** Campo de texto para ingresar el nombre*/
    @FXML
    private TextField txtName;

    /** Campo de texto para ingresar el correo electrónico */
    @FXML
    private TextField txtEmail;

    /** Campo de texto para ingresar la edad */
    @FXML
    private TextField txtEdad;

    /** Lista observable que contiene los datos mostrados en el ListView */
    @FXML
    private ObservableList<String> data= FXCollections.observableArrayList();

    /** Servicio que gestiona la lógica de personas */
    private PersonService service=new PersonService();

    /**
     * Inicializa el controlador cargando los datos desde archivo
     * y vinculando la lista observable al ListView.
     */
    @FXML
    public void initialize(){
        loadFromFile();
        listView.setItems(data);
    }

    /**
     * Recarga los datos desde el archivo.
     */
    @FXML
    public void onReload(){
        loadFromFile();
    }

    /**
     * Carga los datos desde el repositorio y actualiza la lista.
     * Muestra mensajes de éxito o error en la etiqueta.
     */
    private void loadFromFile() {
        try{
            List<String> items=service.loadDataForListView();
            data.setAll(items);
            lblMsg.setText("Datos cargados con exito");
            lblMsg.setStyle("-fx-text-fill: green");
        }catch (IOException e){
            lblMsg.setText("Error al cargar los archivos: "+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }

    /**
     * Agrega una nueva persona utilizando los datos ingresados en los campos de texto y recarga la lista.
     * Muestra mensajes de éxito o error en la etiqueta.
     */
    @FXML
    public void onAdd() {

        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String edad=txtEdad.getText();
            service.addPerson(name, email, edad);
            lblMsg.setText("Persona creada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtEmail.clear();
            txtName.clear();
            txtEdad.clear();
            loadFromFile();
        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");

        } catch (IllegalArgumentException e){
            lblMsg.setText("Hubo un error con los datos: "+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }
    }
}
