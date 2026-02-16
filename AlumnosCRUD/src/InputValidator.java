import java.util.Scanner;

public class InputValidator {

    //Instancia de Menu
    Menu menu1=new Menu();

    /**
     * Metodo que valida la opción a elegir
     * @param scanner -> declarado en Main
     * @return -> int
     */
    protected int validateOption( Scanner scanner){
        int input;
        while (true){
            System.out.println("\nIngresa la opción deseada");
            if(scanner.hasNextInt()){
                input=scanner.nextInt();
                return input;
            }else {
                System.out.println("Valor ingresado no valido");
                menu1.printMenu();
                scanner.next();
            }
        }
    }


    /**
     * Metodo para validar que el ID sea válido
     * @param scanner -> declarado en Main
     * @param message -> es un parámetro (Envía mensaje a terminal)
     * @return -> int
     */
    protected int validateIntId(Scanner scanner, String message){
        int input;
        while (true){
            System.out.println(message);
            if (scanner.hasNextInt()){
                input=scanner.nextInt();
                return input;
            }else {
                System.out.println("Valor ingresado no valido, no es numérico");
                scanner.next();
            }
        }

    }
}
