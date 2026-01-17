import java.util.Scanner;

/**
 * Clase principal Main permite enviar los valores obtenidos
 * de la suma resultante de una secuencia cuyo numero final fue ingresado por el usuario
 * @author Salgado Uresti Rene Alejandro - 2E
 */
public class Main {
    /**
     * Variable que almacena la suma de la secuiencia
     */
    public static int SUMATORIA = 0;

    /**
     * Inicia el programa, ejecuta los procesos
     * @param args Arreglo de strings
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numeroIngresado = obtenerInt(sc, "Ingresa el valor entero");
        int sumaFinal=calcularSuma(numeroIngresado);
        System.out.println("El resultado de la sumatoria es: "+sumaFinal);

    }

    /**
     * Metodo que retorna un valor capturado por terminal
     * @param sc -> previeamente declarado en main
     * @param mensaje -> es un parametro
     * @return -> entero
     */
    public static int obtenerInt (Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();
    }

    /**
     * Metodo que calcula la suma acumulada desde 1 hasta el valor ingresado por el usuario
     * @param numeroIngresado El limite superior hasta el cual se realizara la secuencia
     * @return -> La suma total acumulada de la secuencia
     */
    public static int calcularSuma ( int numeroIngresado){
        for (int contador = 1; contador <= numeroIngresado; contador++) {
            SUMATORIA = contador + SUMATORIA;
        }
        return SUMATORIA;
    }

}
