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
            result.add(name+" - "+email+ " - "+edad);
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

    /**
     * Obtiene todas las líneas no nulas y no vacías
     * desde el repositorio.
     * @return Lista de líneas limpias
     * @throws IOException si ocurre un error al leer el repositorio
     */
    private List<String> getCleanLines() throws IOException {
        List<String> lines=repository.readAllLines();
        List<String> cleanLines = new ArrayList<>();

        for(String line : lines){
            if (line!=null && !line.isBlank()){
                cleanLines.add(line);
            }
        }
        return cleanLines;
    }

    /**
     * Actualiza los datos de una persona en la posición indicada
     * dentro del repositorio y guarda los cambios.
     * @param index posición de la persona a actualizar (>= 0)
     * @param name  nuevo nombre
     * @param email nuevo correo electrónico
     * @param edad  nueva edad
     * @throws IllegalArgumentException si el índice es inválido
     * @throws IOException si ocurre un error al leer o guardar datos
     */
    public void updatePerson(int index, String name,String email, String edad) throws IOException {
        validate(name, email, edad);
        if (index<0){throw new IllegalArgumentException("El indice es invalido");}
        List<String> data= getCleanLines();
        data.set(index,name+","+email+","+edad);
        repository.saveFile(data);
    }

    /**
     * Elimina a la persona en la posición indicada
     * dentro del repositorio y guarda los cambios.
     * @param index posición de la persona a eliminar (>= 0)
     * @param name  nombre de la persona (validación)
     * @param email correo electrónico de la persona (validación)
     * @param edad  edad de la persona (validación)
     * @throws IllegalArgumentException si el índice es inválido
     * @throws IOException si ocurre un error al leer o guardar datos
     */
    public void deletePerson(int index, String name,String email, String edad) throws IOException {
        validate(name, email, edad);
        if (index<0){throw new IllegalArgumentException("El indice es invalido");}
        List<String> data= getCleanLines();
        data.remove(index);
        repository.saveFile(data);
    }
}
