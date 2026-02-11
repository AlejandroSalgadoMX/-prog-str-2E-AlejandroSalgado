import java.util.Scanner;

/**
 * @author Salgado Uresti Rene Alejandro - 2E
 */
public class Main {
    public static void main(String[] args) {

        //Declaracion de arreglo
        Persona[] personas = new Persona[20];
        //Declaracion de scanner
        Scanner scanner=new Scanner(System.in);

        //Instancia de clases
        Menu menu1=new Menu();
        InputValidator inputValidator1=new InputValidator();
        ProcessPersona process=new ProcessPersona();

        //Process
        int option;
        do {
            menu1.printMenu();
            option = inputValidator1.validateOption(scanner);
            switch (option) {
                case 0:
                    System.out.println("Cerrando programa....");
                    break;
                case 1:
                    System.out.println("\n--------------------------------\n");
                    System.out.println("Alta \n");
                    process.up(personas, scanner);
                    System.out.println("\n---------------------------------\n");
                    break;
                case 2:
                    System.out.println("\n---------------------------------\n");
                    System.out.println("Buscar por ID\n");
                    process.searchID(personas, scanner);
                    System.out.println("\n----------------------------------\n");
                    break;
                case 3:
                    System.out.println("\n-----------------------------------\n");
                    System.out.println("Baja Logica\n");
                    process.downLogicFromID(personas, scanner);
                    System.out.println("\n-----------------------------------\n");
                    break;
                case 4:
                    System.out.println("\n-----------------------------------\n");
                    System.out.println("Listar Activos\n");
                    process.listActiveID(personas);
                    System.out.println("\n-----------------------------------\n");
                    break;
                case 5:
                    System.out.println("\n-----------------------------------\n");
                    System.out.println("Cambiar Nombre\n");
                    process.updateNameFromID(personas, scanner);
                    System.out.println("\n-----------------------------------\n");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (option != 0);
    }
}