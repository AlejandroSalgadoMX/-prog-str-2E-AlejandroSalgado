import java.util.Scanner;
/**
 * @author Salgado Uresti Rene Alejandro - 2E
 */
public class ProcessPersona {


    //Instancia de InputValidator
    InputValidator validator=new InputValidator();


    /**
     * Metodo para dar de alta y llenar un arreglo
     * @param personas -> arreglo
     * @param scanner -> Declarado en Main
     */
    protected void up(Persona[] personas, Scanner scanner){
        String name="";
        int id=validator.validateIntId(scanner,"Ingresa el ID de la persona: ");
        if (id<=0){
            System.out.println("No se admiten valor menores o iguales a 0");
            return;
        } else if (verifyID(id,personas)) {
            System.out.println("ID no valido, ya existe");
            return;
        } else {
            System.out.println("Ingresa el nombre de la persona: ");
            name=scanner.next();
            if (name.isBlank()){
                System.out.println("No se admite un nombre vacio");
                scanner.next();
            }
        }
        int indiceInsercion=getIndex(personas);
        if (indiceInsercion==-1){
            System.out.println("El arreglo esta lleno");
            return;
        }
        Persona persona1=new Persona(id,name);
        personas[indiceInsercion]=persona1;
        System.out.println("\n"+persona1.toString());
    }


    /**
     * Metodo para verificar que un valor dentro del arreglo no exista
     * @param id -> int
     * @param personas -> arreglo
     * @return -> boolean
     */
    private boolean verifyID(int id, Persona[] personas){
        for (Persona persona : personas) {
            if(persona!=null && persona.getId()==id) {
                return true;
            }
        }
        return false;
    }


    /**
     * Metodo para verificar que un espacio en el arreglo este vacio, o que no este lleno
     * @param personas -> arreglo
     * @return -> index (int)
     */
    private int getIndex(Persona[] personas){
        for (int i = 0; i < personas.length; i++) {
            if(personas[i]==null){
                return i;
            }
        }
        return -1;
    }


    /**
     * Metodo para buscar un ID e imprime la informacion que contenga ese ID
     * @param personas -> arreglo
     * @param scanner -> declarado en Main
     */
    protected void searchID(Persona[] personas, Scanner scanner){
        int id=validator.validateIntId(scanner,"Ingresa el ID a buscar:");
        boolean validateID=verifyID(id,personas);
        if(validateID) {
            for (Persona persona : personas) {
                if (persona != null) {
                    if(persona.isActive()) {
                        if (persona.getId() == id) {
                            System.out.println(persona.toString());
                        }
                    }else {
                        System.out.println("ID dado de baja");
                    }
                }
            }
        }else {
            System.out.println("ID no encontrado");
        }
    }

    /**
     * Metodo para cambiar un parametro boolean a (false)
     * @param personas -> arreglo
     * @param scanner -> declarado en Main
     */
    protected void downLogicFromID(Persona [] personas,Scanner scanner){
        int id=validator.validateIntId(scanner,"Ingresa el ID para dar de baja:");
        boolean validateID=verifyID(id,personas);
        if(validateID) {
            for (Persona persona : personas) {
                if (persona != null ) {
                    if(persona.isActive()) {
                        if (persona.getId() == id) {
                            persona.setActive(false);
                            System.out.println(persona.toString());
                        }
                    }else {
                        System.out.println("ID dado de baja");
                    }
                }
            }
        }else {
            System.out.println("ID no encontrado");
        }
    }


    /**
     * Metodo para imprimir los datos que estan dentro del arreglo, solo si un parametro boolean es (true)
     * @param personas -> arreglo
     */
    protected void listActiveID(Persona[] personas){
        for (Persona persona : personas){
            if (persona!=null && persona.isActive() ){
                System.out.println(persona.toString());
            }
        }
    }


    /**
     * Metodo para cambiar el valor de un String dentro del arreglo
     * @param personas -> arreglo
     * @param scanner -> declarado en Main
     */
    protected void updateNameFromID(Persona[] personas, Scanner scanner){
        int id=validator.validateIntId(scanner,"Ingresa el ID para cambiar el nombre:");
        boolean validateID=verifyID(id,personas);
        if (validateID){
            for(Persona persona : personas){
                if (persona!=null){
                    if (persona.isActive()){
                        if (persona.getId() == id) {
                            System.out.println("Ingresa el nombre: ");
                            String name =scanner.next();
                            if (name.isBlank()){
                                System.out.println("No se admite un nombre vacio");
                                return;
                            }else {
                                persona.setName(name);
                                System.out.println(persona.toString());
                            }
                        }
                    }else {
                        System.out.println("ID dado de baja");
                        return;
                    }
                }
            }
        }else {
            System.out.println("ID no encontrado");
        }
    }


}