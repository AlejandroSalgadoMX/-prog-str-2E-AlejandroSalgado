import java.util.Scanner;
/**
 * @author Salgado Uresti Rene Alejandro - 2E
 */
public class Main {
    public static void main(String[] args) {

        //Declaración de arreglo
        Alumno[] alumnos = new Alumno[25];
        //Declaración de scanner
        Scanner scanner=new Scanner(System.in);


        //Instancia de clases
        Menu menu1=new Menu();
        InputValidator inputValidator1=new InputValidator();
        ProcessAlumno process1=new ProcessAlumno();

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
                    System.out.println("Alta alumno\n");
                    process1.up(alumnos,scanner);
                    System.out.println("\n---------------------------------\n");
                    break;
                case 2:
                    System.out.println("\n---------------------------------\n");
                    System.out.println("Buscar por ID\n");
                    process1.searchID(alumnos,scanner);
                    System.out.println("\n----------------------------------\n");
                    break;
                case 3:
                    System.out.println("\n-----------------------------------\n");
                    System.out.println("Actualizar Promedio por ID\n");
                    process1.updateGradeFromID(alumnos,scanner);
                    System.out.println("\n-----------------------------------\n");
                    break;
                case 4:
                    System.out.println("\n-----------------------------------\n");
                    System.out.println("Baja Logica por ID\n");
                    process1.downLogicFromID(alumnos,scanner);
                    System.out.println("\n-----------------------------------\n");
                    break;
                case 5:
                    System.out.println("\n-----------------------------------\n");
                    System.out.println("Listar activos\n");
                    process1.listActiveID(alumnos);
                    System.out.println("\n-----------------------------------\n");
                    break;
                case 6:
                    System.out.println("\n-----------------------------------\n");
                    System.out.println("Reportes\n");
                    process1.printReport(alumnos);
                    System.out.println("\n-----------------------------------\n");
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        } while (option != 0);
    }

}
