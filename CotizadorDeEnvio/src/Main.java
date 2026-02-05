import java.util.Scanner;
/**
 * @author Salgado Uresti Rene Alejandro - 2E
 */
public class Main {
    /**
     * Variables publicas que almacenan los valores ingresados por el usuario
     */
    public static double pesoKG;
    public static int distanciaKm;
    public static int tipoDeServicio;
    public static boolean esZonaRemota;

    /**
     * Variables publicas que almacenan los valores resultantes del proceso y de diversos calculos
     */
    public static double subTotal;
    public static double IVACalculado;
    public static double totalFinal;

    public static void main(String[] args) throws Exception{

        InputValidator inputValidator1= new InputValidator();
        Scanner scanner= new Scanner(System.in);

        //Input
        pesoKG=inputValidator1.validarPeso(scanner,"Ingresa el peso en Kg: ");
        distanciaKm=inputValidator1.validarDistancia(scanner,"Ingresa la distancia en Km");
        tipoDeServicio=inputValidator1.validarTipoDeServicio(scanner,"Ingresa el tipo de servicio: ");
        esZonaRemota=inputValidator1.validarZonaRemota(scanner,"Es zona remota? \n(SI - NO)");

        //Process
        subTotal=ShippingCalculator.calcularSubtotal();
        IVACalculado = ShippingCalculator.calcularIVA(ShippingCalculator.subtotal);
        totalFinal = ShippingCalculator.calcularTotal(ShippingCalculator.subtotal, ShippingCalculator.ivaCalculado);

        //Output
        Ticket.imprimirTicket();

    }
}
