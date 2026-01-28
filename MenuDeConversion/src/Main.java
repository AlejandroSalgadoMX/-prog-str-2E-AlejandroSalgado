import java.util.Scanner;
/**
 * @author Salgado Uresti Rene Alejandro - 2E
 */
public class Main {
    /**
     * Constante que indica el limite superior del ciclo
     */
    public static int LIMITESUPERIOR=5;

    /**
     * Constantes para los contadores
     */
    public static int CONTADORTOTAL=0;
    public static int CONTADORCAF=0;
    public static int CONTADORFAC=0;
    public static int CONTADORKMAMI=0;
    public static int CONTADORMIAKM=0;

    /**
     * Constantes para la conversion de Km a Millas y viceversa
     */
    public static double CONSTANTEKM=0.62137119;
    public static double CONSTANTEMI=1.609344;

    /**
     * Constantes para la conversion de °C a °F y viceversa
     */
    public static double CONSTANTE1Grados=1.8;
    public static double CONSTANTE2Grados=32;
    public static double CONSTANTE3Grados=0.555555556;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        double valorIngresado;
        double resultado;
        do {
            mostrarMenu();
            opcion = validarInt(sc);
            switch (opcion) {
                case 1:
                    System.out.println("Conversion a °F");
                    valorIngresado = validarDouble(sc);
                    resultado = convertirAFarenheit(valorIngresado);
                    System.out.println("La conversión a °F es: " + resultado);
                    CONTADORCAF++;
                    break;
                case 2:
                    System.out.println("Conversion a °C");
                    valorIngresado = validarDouble(sc);
                    resultado = convertirACentigrados(valorIngresado);
                    System.out.println("La conversión a °C es: " + resultado);
                    CONTADORFAC++;
                    break;
                case 3:
                    System.out.println("Conversion a Millas");
                    valorIngresado = validarDouble(sc);
                    resultado = convertirKmAMillas(valorIngresado);
                    System.out.println("La conversión a Millas es: " + resultado);
                    CONTADORKMAMI++;
                    break;
                case 4:
                    System.out.println("Conversion a Km");
                    valorIngresado = validarDouble(sc);
                    resultado = convertirMiAKm(valorIngresado);
                    System.out.println("La conversión a Km es: " + resultado);
                    CONTADORMIAKM++;
                    break;
                case 5:
                    System.out.println("Cerrando programa...");
                    break;
                default:
                    System.out.println("Opción invalida, intente nuevamente");
                    break;
            }


        } while (opcion != LIMITESUPERIOR);
        CONTADORTOTAL = CONTADORCAF + CONTADORFAC + CONTADORMIAKM + CONTADORKMAMI;
        System.out.println("Total de conversiones: " + CONTADORTOTAL);
        System.out.println("Conversion °C a °F: " + CONTADORCAF);
        System.out.println("Conversion °F a °C: " + CONTADORFAC);
        System.out.println("Conversión Km a Millas: " + CONTADORKMAMI);
        System.out.println("Conversion Millas A Km: " + CONTADORMIAKM);

        sc.close();
    }

    /**
     * Metodo para validar que un valor introducido sea de tipo int
     * @param sc previamente declarado en main
     * @return -> int
     */
    public static int validarInt(Scanner sc){
        int opcion;
        while (true){
            System.out.println("Ingresa la opcion deseada: ");
            if(sc.hasNextInt()){
                opcion=sc.nextInt();
                return opcion;
            }
            System.out.println("Valor ingresado no valido");
            mostrarMenu();
            sc.next();
        }
    }

    /**
     * Metodo para validar que un valor introducido sea de tipo double
     * @param sc previamente declarado en main
     * @return -> double
     */
    public static double validarDouble(Scanner sc){
        double valorIngresado;
        while (true){
            System.out.println("Ingresa el valor: ");
            if(sc.hasNextDouble()){
                valorIngresado=sc.nextDouble();
                return valorIngresado;
            }
            System.out.println("Valor ingresado no valido");
            sc.next();
        }
    }

    /**
     * Metodo que despliega el menú
     */
    public static void mostrarMenu(){
        System.out.println("-----Menu de conversión-----");
        System.out.println("1) °C a °F");
        System.out.println("2) °F a °C");
        System.out.println("3) Km a Millas");
        System.out.println("4) Millas a Km");
        System.out.println("5) Salir");
    }

    /**
     * Metodo que realiza la conversion de °C a °F
     * @param valorIngresado introducido por terminal
     * @return -> el resultado de la conversion (double)
     */
    public static double convertirAFarenheit(double valorIngresado){
        return (valorIngresado*CONSTANTE1Grados)+CONSTANTE2Grados;
    }

    /**
     * Metodo que realiza la conversion de °F a °C
     * @param valorIngresado introducido por terminal
     * @return -> el resultado de la conversion (double)
     */
    public static double convertirACentigrados(double valorIngresado){
        return (valorIngresado-CONSTANTE2Grados)*CONSTANTE3Grados;
    }

    /**
     * Metodo que realiza la conversion de Km a Millas
     * @param valorIngresado introducido por terminal
     * @return -> el resultado de la conversion (double)
     */
    public static double convertirKmAMillas(double valorIngresado){
        return (valorIngresado*CONSTANTEKM);
    }

    /**
     * Metodo que realiza la conversion de Millas a Km
     * @param valorIngresado introducido por terminal
     * @return -> el resultado de la conversion (double)
     */
    public static double convertirMiAKm(double valorIngresado){
        return (valorIngresado*CONSTANTEMI);
    }

}

