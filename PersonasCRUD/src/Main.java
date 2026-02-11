import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Persona[] personas = new Persona[20];

        Scanner scanner=new Scanner(System.in);
        Menu menu1=new Menu();
        InputValidator inputValidator1=new InputValidator();

        int option;
        do {
            menu1.printMenu();
            option=inputValidator1.validateOption(scanner,"Ingresa la opcion deseada");
            switch (option){
                case 0:
                    System.out.println("Cerrando programa....");
                    break;
                case 1:
                    System.out.println("--------------------------------\n");
                    System.out.println("");

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }

        }while (option!=0);


    }
}
