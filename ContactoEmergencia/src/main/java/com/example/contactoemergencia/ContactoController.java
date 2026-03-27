package com.example.contactoemergencia;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

/**
 * Controlador para la gestión de contactos de emergencia.
 * Maneja las operaciones de agregar, buscar, actualizar y eliminar contactos,
 * así como la validación y la interacción con la interfaz gráfica.
 */
public class ContactoController {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox<String> cmbParentesco;
    @FXML
    private ListView<Contacto> listViewContactos;

    private ObservableList<Contacto> contactos;
    private final String[] parentescos = {
            "Padre", "Madre", "Hermano", "Hermana",
            "Abuelo", "Abuela", "Tío", "Tía"
    };

    /**
     * Inicializa el controlador.
     * Configura la lista de contactos y carga las opciones de parentesco.
     */
    public void initialize() {
        contactos = FXCollections.observableArrayList();
        cmbParentesco.getItems().addAll(parentescos);
        listViewContactos.setItems(contactos);
    }

    /**
     * Agrega un nuevo contacto si los datos son válidos.
     */
    @FXML
    public void agregarContacto() {
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String parentesco = cmbParentesco.getValue();

        if (validarContacto(nombre, telefono, parentesco)) {
            Contacto nuevoContacto = new Contacto(nombre, telefono, parentesco);
            contactos.add(nuevoContacto);
            limpiarCampos();
        }
    }

    /**
     * Busca un contacto por nombre y muestra sus datos en los campos.
     */
    @FXML
    public void buscarContacto() {
        String nombre = txtNombre.getText().trim();
        Optional<Contacto> contactoOpt = contactos.stream()
                .filter(c -> c.getNombre().equals(nombre))
                .findFirst();

        if (contactoOpt.isPresent()) {
            Contacto contacto = contactoOpt.get();
            txtTelefono.setText(contacto.getTelefono());
            cmbParentesco.setValue(contacto.getParentesco());
        } else {
            mostrarMensaje("El contacto no se encuentra guardado.");
        }
    }

    /**
     * Actualiza los datos de un contacto existente.
     */
    @FXML
    public void actualizarContacto() {
        String nombre = txtNombre.getText().trim();
        Optional<Contacto> contactoOpt = contactos.stream()
                .filter(c -> c.getNombre().equals(nombre))
                .findFirst();

        if (contactoOpt.isPresent()) {
            Contacto contacto = contactoOpt.get();
            contacto.setTelefono(txtTelefono.getText().trim());
            contacto.setParentesco(cmbParentesco.getValue());
            listViewContactos.refresh();
            limpiarCampos();
        } else {
            mostrarMensaje("Contacto no existente.");
        }
    }

    /**
     * Elimina un contacto por nombre.
     */
    @FXML
    public void eliminarContacto() {
        String nombre = txtNombre.getText().trim();
        contactos.removeIf(c -> c.getNombre().equals(nombre));
        limpiarCampos();
    }

    /**
     * Limpia los campos de entrada de la interfaz.
     */
    @FXML
    public void limpiarCampos() {
        txtNombre.clear();
        txtTelefono.clear();
        cmbParentesco.setValue(null);
    }

    /**
     * Valida los datos de un contacto antes de agregarlo.
     * @param nombre nombre del contacto
     * @param telefono número de teléfono
     * @param parentesco relación con la persona
     * @return true si los datos son válidos, false en caso contrario
     */
    private boolean validarContacto(String nombre, String telefono, String parentesco) {
        if (nombre.isEmpty() || telefono.isEmpty() || parentesco == null) {
            mostrarMensaje("Llenar todos los campos (obligatorio).");
            return false;
        }
        if (telefono.length() != 10) {
            mostrarMensaje("El teléfono debe ser de 10 dígitos.");
            return false;
        }
        if (contactos.stream().anyMatch(c -> c.getNombre().equals(nombre))) {
            mostrarMensaje("Ya existe un contacto con ese nombre.");
            return false;
        }
        return true;
    }

    /**
     * Muestra un mensaje informativo en un cuadro de diálogo.
     * @param mensaje texto a mostrar
     */
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}