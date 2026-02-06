import java.util.Scanner;
/**
 * Clase usada para validar los valores ingresados
 * @author Salgado Uresti Rene Alejandro - 2E
 */
public class InputValidator {

    /**
     * Constantes usadas para determinar un rango de un valor ingresado
     */
    private final double MINIMUMRANGE=0;
    private final double MAXIMUMRANGE=100;

    /**
     * Constructor vacio
     */
    public InputValidator(){}

    /**
     * Metodo que valida el texto ingresado por el usuario
     * @param scanner -> previamente declarado en main
     * @param message -> es un parametro (Envia un mensaje a terminal)
     * @return -> String no nulo
     */
    protected String validateString(Scanner scanner, String message) {
        String input;
        while (true) {
            System.out.println(message);
            input=scanner.nextLine();
            if (input == null) {
                System.out.println("El texto no puede ser nulo.");
            }else if (input.trim().isEmpty()) {
                System.out.println("El texto no puede estar vacío o solo contener espacios.");
            }else {
                return input;
            }
        }
    }

    /**
     * Metodo para validar un valor ingresado y determinar si esta en un rango impuesto (0 - 100)
     * @param scanner -> previamente declarado en main
     * @param message -> es un parametro (Envia mensaje a terminal)
     * @return -> int en rango
     */
    protected int validateInt(Scanner scanner, String message){
        int input;
        while (true){
            System.out.println(message);
            if(scanner.hasNextInt()){
                input=scanner.nextInt();
                if (input >= MINIMUMRANGE && input <= MAXIMUMRANGE){
                    return input;
                }else{
                System.out.println("Valor ingresado fuera de rango");
                }

            }else {
                System.out.println("Valor ingresado no valido");
                scanner.next();
            }
        }
    }

    /**
     * Metodo para validar un valor ingresado y determinar si esta en un rango impuesto (0 - 100)
     * @param scanner - previamente declarado en main
     * @param message - es un parametro (Envia un mensaje a terminal)
     * @return -> double
     */
    protected double validateDouble(Scanner scanner, String message){
        double input;
        while (true){
            System.out.println(message);
            if(scanner.hasNextDouble()){
                input=scanner.nextDouble();
                if (input >= MINIMUMRANGE && input <= MAXIMUMRANGE){
                    return input;
                }else{
                    System.out.println("Valor ingresado fuera de rango");
                }

            }else {
                System.out.println("Valor ingresado no valido");
                scanner.next();
            }
        }
    }

    /**
     * Metodo para convertir un valor String a boolean y verificar que no sea una respuesta no valida
     * @param scanner -> previamente declarado en main
     * @param message -> es un parametro (Envia un mensaje a terminal)
     * @return -> boolean
     */
    public boolean validateBoolean(Scanner scanner, String message){
        String input = "";
        while (true) {
            System.out.println(message);
            if(scanner.hasNext()) {
                input = scanner.next();
                if(input.equals("Si") || input.equals("SI") || input.equals("si")){
                    return true;
                }else if (input.equals("No") || input.equals("NO") || input.equals("no")){
                    return false;
                }else {
                    System.out.println("Ingresa una respuesta valida");
                }
            }else {
                System.out.println("Dato ingresado no valido");
                scanner.next();
            }
        }
    }

}
