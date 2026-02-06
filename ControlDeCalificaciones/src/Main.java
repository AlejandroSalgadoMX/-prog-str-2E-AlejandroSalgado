import java.util.Scanner;
/**
 * Clase principal
 * @author Salgado Urest Rene Alejandro - 2E
 */
public class Main {

    public static void main(String[] args) throws  Exception{

        //Declaracion de Scanner
        Scanner scanner=new Scanner(System.in);

        //Instancia de la clase InputValidator
        InputValidator inputValidator1=new InputValidator();

        //Instancia de la clase GradeBook
        GradeBook gradeBook1=new GradeBook();

        //Input
        String studentName=inputValidator1.validateString(scanner, "Ingresa tu nombre: ");
        double note1=inputValidator1.validateDouble(scanner,"Ingresa la calificacion del Parcial 1 (0-100): ");
        double note2=inputValidator1.validateDouble(scanner,"Ingresa la calificacion del Parcial 2 (0-100): ");
        double note3=inputValidator1.validateDouble(scanner,"Ingresa la calificacion del Parcial 3 (0-100): ");
        int assistance =inputValidator1.validateInt(scanner,"Ingresa tus asistencias (0%-100%): ");
        boolean project=inputValidator1.validateBoolean(scanner,"¿Entregaste proyecto?: (SI - NO)");

        //Process
        gradeBook1.process(note1,note2,note3, assistance,project);

        //Output
        gradeBook1.printGradeBook(studentName,note1,note2,note3, assistance,project);

    }
}