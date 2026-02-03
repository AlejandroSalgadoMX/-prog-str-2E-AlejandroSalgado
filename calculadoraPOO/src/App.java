import java.util.Scanner;

/**
 * @author Salgado Uresti Rene Alejandro - 2E
 */
public class App {

    public static void main(String[] args) throws Exception{

        /**
         * Instancia de la clase Ticket
         */
        Ticket ticket1= new Ticket();

        /**
         * Instancia de la clase InputValidator
         */
        InputValidator inputValidator= new InputValidator();//Instancia de una clase inputValidator

        Scanner sc= new Scanner(System.in);

        /**
         * Input
         */
        int cantidad=inputValidator.obtenerNumeroEntero("Ingresa la cantidad de productos: ", sc);

        /**
         * Process
         */
        ticket1.procesar(cantidad);

        /**
         * Output
         */
        ticket1.imprimirTicket(cantidad);


    }

}
