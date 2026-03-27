package com.example.contactoemergencia;

/**
 * Representa un contacto de emergencia con nombre, teléfono y parentesco.
 * Se utiliza para almacenar y manipular información básica de un contacto.
 */
public class Contacto {
    private String nombre;
    private String telefono;
    private String parentesco;

    /**
     * Crea un nuevo contacto de emergencia.
     * @param nombre Nombre del contacto
     * @param telefono Número de teléfono del contacto
     * @param parentesco Relación del contacto con la persona
     */
    public Contacto(String nombre, String telefono, String parentesco) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.parentesco = parentesco;
    }

    /**
     * Obtiene el nombre del contacto.
     * @return nombre del contacto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el número de teléfono del contacto.
     * @return teléfono del contacto
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Obtiene el parentesco del contacto.
     * @return parentesco del contacto
     */
    public String getParentesco() {
        return parentesco;
    }

    /**
     * Actualiza el número de teléfono del contacto.
     * @param telefono nuevo número de teléfono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Actualiza el parentesco del contacto.
     * @param parentesco nuevo parentesco
     */
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    /**
     * Devuelve una representación en texto del contacto.
     * @return cadena con nombre, teléfono y parentesco
     */
    @Override
    public String toString() {
        return nombre + " - " + telefono + " (" + parentesco + ")";
    }
}