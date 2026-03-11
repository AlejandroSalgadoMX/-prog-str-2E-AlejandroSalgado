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

public class AppControllers {

    @FXML
    private Label lblMsg;
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtEmail;

    @FXML
    private ObservableList<String> data= FXCollections.observableArrayList();

    private PersonService service=new PersonService();

    @FXML
    public void initialize(){
        loadFromFile();
        listView.setItems(data);
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }

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

    @FXML
    public void onAdd() {

        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            service.addPerson(name, email);
            lblMsg.setText("Persona creada con exito");
            lblMsg.setStyle("-fx-text-fill: green");
            txtEmail.clear();
            txtName.clear();
        } catch (IOException e) {
            lblMsg.setText("Hubo un error con el archivo");
            lblMsg.setStyle("-fx-text-fill: red");

        } catch (IllegalArgumentException e){
            lblMsg.setText("Hubo un error con los datos: "+e.getMessage());
            lblMsg.setStyle("-fx-text-fill: red");
        }


    }
}
