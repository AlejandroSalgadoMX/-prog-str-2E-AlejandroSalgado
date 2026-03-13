package com.example.demolistview.repositories;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Repositorio encargado de manejar la persistencia de datos de personas en un archivo CSV.
 * Proporciona métodos para leer y escribir líneas en el archivo.
 */
public class PersonFileRepository {

    /** Ruta del archivo donde se almacenan los datos */
    private final Path filePath = Paths.get("data", "personas.csv");

    /**
     * Verifica si el archivo existe, y lo crea en caso contrario.
     * @throws IOException Si ocurre un error al crear el archivo
     */
    private void ensureFile() throws IOException {
        if (Files.notExists(filePath)){
            Files.createFile(filePath);
        }
    }

    /**
     * Lee todas las líneas del archivo CSV.
     * @return Lista de cadenas con los datos almacenados
     * @throws IOException Si ocurre un error al leer el archivo
     */
    public List<String> readAllLines() throws IOException {
        ensureFile();
        return Files.readAllLines(filePath);
    }

    /**
     * Agrega una nueva línea al archivo CSV.
     * @param line Cadena que representa los datos de una persona
     * @throws IOException Si ocurre un error al escribir en el archivo
     */
    public void appendNewLine(String line) throws IOException {
        ensureFile();
        Files.writeString(filePath, line+System.lineSeparator(), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }
}
