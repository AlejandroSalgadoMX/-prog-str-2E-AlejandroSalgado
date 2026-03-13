package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para gestionar datos de personas.
 * Se encarga de cargar información desde el repositorio y
 * agregar nuevas entradas con validación básica.
 */
public class PersonService {

    /** Repositorio que maneja la persistencia de datos en archivo */
    PersonFileRepository repository= new PersonFileRepository();

    /**
     * Carga los datos desde el repositorio y los prepara para mostrarse en un ListView.
     * @return Lista de cadenas con nombre y email formateados
     * @throws IOException Si ocurre un error al leer el archivo
     */
    public List<String> loadDataForListView() throws IOException {
        List<String> lines=repository.readAllLines();
        List<String> result=new ArrayList<>();

        for (String line:lines){
            if (line==null || line.isBlank())continue;
            String [] parts=line.split(",");
            String name=parts[0];
            String email=parts[1];
            String edad=parts[2];
            result.add("Nombre: "+name+" - Email: "+email+ " - Edad:"+edad);
        }
        return result;
    }

    /**
     * Agrega una nueva persona al repositorio.
     * @param name  Nombre de la persona
     * @param email Correo electrónico de la persona
     * @param edad  Edad de la persona
     * @throws IOException Si ocurre un error al escribir en el archivo
     * @throws IllegalArgumentException Si los datos no cumplen con las validaciones
     */
    public void addPerson(String name, String email, String edad) throws IOException {
        validate(name, email, edad);
        repository.appendNewLine(name+ ","+email+","+edad);
    }

    /**
     * Valida los datos de una persona.
     * @param name  Nombre a validar
     * @param email Correo electrónico a validar
     * @param edad Edad a validar
     * @throws IllegalArgumentException Si el nombre o el email son inválidos
     */
    private void validate(String name, String email, String edad){
        if (name==null || name.isBlank() || name.length()<3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }
        String em=(email==null) ? "" : email.trim();
        if (em.isBlank()|| !em.contains("@")|| !em.contains(".") ){
            throw new IllegalArgumentException("El email es incorrecto");
        }
        String edadNotNull=(edad==null) ? "" : edad.trim();
        int parsEdad = Integer.parseInt(edadNotNull);
        if (parsEdad<0){
            throw new IllegalArgumentException("No se admiten numeros negativos");
        }else {
            if (parsEdad>120 || parsEdad<18){
                throw new IllegalArgumentException("Edad invalida");
            }
        }

    }
}
