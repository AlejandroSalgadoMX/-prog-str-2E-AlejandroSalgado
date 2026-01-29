import java.util.Random;
import java.util.Scanner;

public class Main {
    /**
     * Determinan el maximo de intentos y el contador de los intentos
     */
    public static int INTENTOSMAXIMOS=7;
    public static int NUMERODEINTENTOS=0;

    /**
     * Determina los limites de nuestro numero secreto
     */
    public static int LIMITEINFERIOR=1;
    public static int LIMITESUPERIOR=100;

    /**
     * Determina si el usuario gano o perdio
     */
    public static boolean BANDERAGANO=false;

    /**
     * Contadores para visualizar cuantas veces se ingreso un valor invalido o fuera de rango
     */
    public static int CONTADORFUERADERANGO=0;
    public static int CONTADORVALORINVALIDO=0;

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(LIMITESUPERIOR) + LIMITEINFERIOR;

        System.out.println("Adivina el numero entre (1-100) tienes " + INTENTOSMAXIMOS + " intentos");

        while(NUMERODEINTENTOS<INTENTOSMAXIMOS){
            int valorIngresado=validarInt(scanner,"Intento : "+(NUMERODEINTENTOS+1));
            NUMERODEINTENTOS++;
            if(valorIngresado==numeroSecreto){
                System.out.println("!Ganaste!");
                BANDERAGANO=true;
                break;
            }else if (valorIngresado>numeroSecreto){
                System.out.println("El numero secreto es menor");

            }else {
                System.out.println("EL numero secreto es mayor");
            }

        }
        if(!BANDERAGANO){
            System.out.println("Perdiste,el numero secreto era: "+numeroSecreto);
        }

        scanner.close();
        System.out.println("Te pasaste del rango "+CONTADORFUERADERANGO+" veces");
        System.out.println("Ingresaste datos invalidos "+CONTADORVALORINVALIDO+" veces");

    }

    /**
     * Metodo para validar si un numero ingresado es (int), de igual forma valida
     * nuestro rango determinado, ademas de contar cuantas veces se ingreso
     * un valor invalido o fuera de rango
     * @param scanner -> declarado en main
     * @param mensaje -> es un parametro para mostrar un mensaje en terminal
     * @return -> int, retorna el valor ingresado solo si es valido
     */
    public static int validarInt(Scanner scanner, String mensaje ){
        int valorIngresado;
        while (true){
            System.out.println(mensaje);
            if (scanner.hasNextInt()){
                valorIngresado=scanner.nextInt();
                if(valorIngresado>=LIMITEINFERIOR && valorIngresado<=LIMITESUPERIOR){
                    return valorIngresado;
                }
                System.out.println("Numero fuera de rango debe de ser entre "+LIMITEINFERIOR+ " y "+LIMITESUPERIOR);
                System.out.println("Intente nuevamente: ");
                CONTADORFUERADERANGO++;
            }else{
                System.out.println("Valor ingresado invalido");
                System.out.println("Intente nuevamente: ");
                CONTADORVALORINVALIDO++;
                scanner.next();
            }


        }
    }

}