import java.util.Scanner;

public class InputValidator {

    Menu menu1=new Menu();

    protected int validateOption( Scanner scanner, String message){
        int input;
        while (true){
            System.out.println(message);
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




}
