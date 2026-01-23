import java.util.Scanner;

/**
 *
 * @author Salgado Uresti Rene Alejandro - 2E
 */
public class ActividadIfElseTarifa {

    /**
     * Constantes que validan un valor ingresado para determinar si es valido el valor ingresado
     */
    public static int EDADMAYORINVALIDA =120;
    public static int EDADMENORINVALIDA=0;

    /**
     * Constantes que se usan para varificar la tarifa en base a un valor ingresado
     */
    public static int EDADMENORVALIDA=12;
    public static int EDADAMEDIAVALIDA=17;
    public static int EDADAMAYORVALIDA=18;

    /**
     * Constantes que indican un valor de la tarifa
     */
    public static double TARIFAMENOR=50;
    public static double TARIFAMEDIAESTUDIANTE=60;
    public static double TARIFAMAYORESTUDIANTE=90;
    public static double TARIFAMEDIANOESTUDIANTE=80;
    public static double TARIFAMAYORNOESTUDIANTE=120;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int edadIngresada= obtenerInt(sc, "Ingresa tu edad: ");
        if (validarEdad(EDADMAYORINVALIDA, EDADMENORINVALIDA, edadIngresada)){
            System.out.println("Edad valida");
        }else{
            System.out.println("Edad invalida, se cerrara el programa");
            System.exit(0);
        }


        String esEstudiante= obtenerString(sc, "Eres estudiante? SI / NO ");
        if (validarEstudiante(esEstudiante)){
            System.out.println("Fuiste validado como estudiante");
        }else if (!validarEstudiante(esEstudiante)){
            System.out.println("No fuiste validado como estudiante");
        }


        double tarifaFinal=obtenerTarifa(validarEstudiante(esEstudiante),edadIngresada);
        System.out.println("Tu edad es: "+edadIngresada);
        if (validarEstudiante(esEstudiante)){
            System.out.println("Eres estudiante");
        } else if (!validarEstudiante(esEstudiante)) {
            System.out.println("No eres estudiante");
        }
        System.out.println("Tarifa final: $"+tarifaFinal);


    }

    /**
     * Metodo que retorna un valor capturado por terminal
     * @param sc -> Previamente declarado en main
     * @param mensaje -> es un parametro que envia un mensaje a terminal
     * @return -> int
     */
    public static int obtenerInt(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();
    }

    /**
     * Metodo que retorna un valor capturado por terminal
     * @param sc -> previamente declarado en main
     * @param mensaje -> es un parametro que envia un mensaje a terminal
     * @return -> String
     */
    public static String obtenerString(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.next();
    }

    /**
     * Metodo que valida un valor capturado dentro de un rango indicado
     * @param EDADMAYORINVALIDA utilizado para validar un valor
     * @param EDADMENORINVALIDA utilizado para validar un valor
     * @param edadIngresada valor ingresado por terminal
     * @return -> boolean
     */
    public static boolean validarEdad(int EDADMAYORINVALIDA, int EDADMENORINVALIDA, int edadIngresada){
        return edadIngresada>EDADMENORINVALIDA && edadIngresada<EDADMAYORINVALIDA;
    }

    /**
     * Metodo que transforma un valor ingresado (String) en boleano (boolean)
     * @param esEstudiante String capturado en terminal
     * @return -> boolean
     */
    public static boolean validarEstudiante(String esEstudiante){
        if (esEstudiante.equals("SI")||esEstudiante.equals("si")||esEstudiante.equals("Si")){
            return true;
        }else {
            return false;
        }
    }

    /**
     * Metodo que calcula la tarifa final en base a rangos previamente estipulados
     * @param validarEstudiante previamente validado (boolean)
     * @param edadIngresada valor capturado por terminal
     * @return -> double
     */
    public static double obtenerTarifa(boolean validarEstudiante,int edadIngresada) {
        if (edadIngresada<EDADMENORVALIDA){
            return TARIFAMENOR;
        } else if (edadIngresada>=EDADMENORVALIDA && edadIngresada<EDADAMEDIAVALIDA && validarEstudiante) {
            return TARIFAMEDIAESTUDIANTE;
        } else if (edadIngresada>=EDADMENORVALIDA && edadIngresada<EDADAMEDIAVALIDA && !validarEstudiante) {
            return TARIFAMEDIANOESTUDIANTE;
        } else if (edadIngresada>=EDADAMAYORVALIDA && validarEstudiante) {
            return TARIFAMAYORESTUDIANTE;
        } else if (edadIngresada>=EDADAMAYORVALIDA && !validarEstudiante) {
            return TARIFAMAYORNOESTUDIANTE;
        }
        return 0;
    }

}
