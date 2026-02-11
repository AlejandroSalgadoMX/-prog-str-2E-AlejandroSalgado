import java.util.Scanner;

/**
 * @author Salgado Uresti Rene Alejandro - 2E
 */
public class InputValidator {

    //Instancia de Menu
    Menu menu1=new Menu();

    /**
     * Metodo que valida la opcion a elegir
     *
     * @param scanner -> declarado en Main
     * @return -> int
     */
    protected int validateOption( Scanner scanner){
        int input;
        while (true){
            System.out.println("\nIngresa la opcion deseada");
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
     * Metodo para validar que el ID sea valido
     * @param scanner -> declarado en Main
     * @param message -> es un parametro (Envia mensaje a terminal)
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
                System.out.println("Valor ingresado no valido, no es numerico");
                scanner.next();
            }
        }

    }

}