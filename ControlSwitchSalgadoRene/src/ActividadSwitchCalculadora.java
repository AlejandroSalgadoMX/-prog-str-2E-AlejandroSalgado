import java.util.Scanner;

/**
 * @author Salgado Uresti Rene Alejandro - 2E
 */
public class ActividadSwitchCalculadora {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");

        int opcion = obtenerInt(sc, "Ingresa la opcion deseada");

        if (opcion>4 || opcion<1){
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

    public static int obtenerInt(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();
    }

    public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    public static double calcularSuma(double variableA, double variableB){
        return variableA+variableB;
    }

    public static double calcularResta(double variableA, double variableB){
        return variableA-variableB;
    }

    public static double calcularMultiplicacion(double variableA, double variableB){
        return variableA*variableB;
    }

    public static boolean validarDivision(double variableA,double variableB) {
        if (variableB != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static double calcularDivision(double variableA, double variableB){
            return variableA/variableB;

    }
}
