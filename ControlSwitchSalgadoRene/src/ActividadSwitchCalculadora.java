import java.util.Scanner;

/**
 * @author Salgado Uresti Rene Alejandro - 2E
 */
public class ActividadSwitchCalculadora {
    /**
     * Constantes usadas para validar un valor
     */
    public static int LIMITEINFERIOR=1;
    public static int LIMITESUPERIOR=4;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");

        int opcion = obtenerInt(sc, "Ingresa la opcion deseada");

        if (validarOpcion(opcion)){
            System.out.println("Opción inválida");
            System.exit(0);
        }else {
            double variableA = obtenerDouble(sc, "Ingresa el numero: ");
            double variableB = obtenerDouble(sc, "Ingresa el numero:");

            switch (opcion) {
                case 1:
                    double resultadoSuma = calcularSuma(variableA, variableB);
                    System.out.println("El resultado de la suma es: " + resultadoSuma);
                    break;

                case 2:
                    double resultadoResta = calcularResta(variableA, variableB);
                    System.out.println("El resultado de la resta es: " + resultadoResta);
                    break;

                case 3:
                    double resultadoMultiplicacion = calcularMultiplicacion(variableA, variableB);
                    System.out.println("El resultado de la multiplicación es:" + resultadoMultiplicacion);
                    break;

                case 4:
                    if (validarDivision(variableA, variableB)) {
                        double resultadoDivision = calcularDivision(variableA, variableB);
                        System.out.println("El resultado de la división es: " + resultadoDivision);
                    } else {
                        System.out.println("No se puede dividir entre 0");
                    }
                    break;
            }
        }



    }

    /**
     * Metodo que retorna un valor capturado por terminal
     * @param sc previamente declarado en main
     * @param mensaje envia mensaje a terminal
     * @return -> int
     */
    public static int obtenerInt(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();
    }

    /**
     * Metodo que valida que la opcion seleccionada este dentro de los limites impuestos
     * @param opcion capturado por terminal
     * @return -> boolean
     */
    public static boolean validarOpcion(int opcion){
        if (opcion<LIMITEINFERIOR || opcion>LIMITESUPERIOR){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Metodo que retorna un valor capturado por terminal
     * @param sc previamente declarado en main
     * @param mensaje envia mensaje a terminal
     * @return -> double
     */
    public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    /**
     * Metodo para calcular la suma de dos valores
     * @param variableA capturado por terminal
     * @param variableB capturado por terminal
     * @return -> double
     */
    public static double calcularSuma(double variableA, double variableB){
        return variableA+variableB;
    }

    /**
     * Metodo para calcular la resta entre dos valores
     * @param variableA capturado por terminal
     * @param variableB capturado por terminal
     * @return -> double
     */
    public static double calcularResta(double variableA, double variableB){
        return variableA-variableB;
    }

    /**
     * Metodo para calcular la multiplicacion entre dos valores
     * @param variableA capturado por terminal
     * @param variableB capturado por terminal
     * @return -> double
     */
    public static double calcularMultiplicacion(double variableA, double variableB){
        return variableA*variableB;
    }

    /**
     * Metodo para validar si se puede realizar el calculo de la division
     * @param variableA capturado por terminal
     * @param variableB capturado por terminal
     * @return -> boolean
     */
    public static boolean validarDivision(double variableA,double variableB) {
        if (variableB != 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que calcula la division de dos valores
     * @param variableA capturado por terminal
     * @param variableB capturado por terminal
     * @return -> double
     */
    public static double calcularDivision(double variableA, double variableB){
            return variableA/variableB;
    }

}