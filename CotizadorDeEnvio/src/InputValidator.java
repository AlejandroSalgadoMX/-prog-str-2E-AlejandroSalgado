import java.util.Scanner;

public class InputValidator {
    /**
     * Constantes utlizadas para validar el rango de un valor ingresado
     */
    private final int DISTANCIAMINIMA=1;
    private final int DISTANCIAMAXIMA=2000;

    /**
     * Constantes utlizadas para validar el rango de un valor ingresado
     */
    private final double PESOMINIMO=0.1;
    private final double PESOMAXIMO=50.0;

    /**
     * Metodo utilizado para verificar que un valor ingresado sea valido, ademas de verificar un rango
     * @param scanner -> es un parametro
     * @param mensaje -> envia un mensaje a terminal
     * @return -> double
     */
    public double validarPeso(Scanner scanner, String mensaje){
        double valorIngresado;
        while (true){
            System.out.println(mensaje);
            if(scanner.hasNextDouble()){
                valorIngresado= scanner.nextDouble();
                if (valorIngresado>=PESOMINIMO && valorIngresado<=PESOMAXIMO){
                    return valorIngresado;
                }else {
                    System.out.println("Numero ingresado no valido (No esta dentro del rango)");
                }
            }else {
                System.out.println("Dato ingresado no valido");
                scanner.next();
            }
        }
    }

    /**
     * Metodo utilizado para verificar que un valor ingresado sea valido, ademas de verificar un rango
     * @param scanner -> es un parametro
     * @param mensaje -> envia un mensaje a terminal
     * @return -> int
     */
    public int validarDistancia(Scanner scanner, String mensaje){
        int valorIngresado;
        while (true){
            System.out.println(mensaje);
            if(scanner.hasNextInt()){
                valorIngresado= scanner.nextInt();
                if (valorIngresado>=DISTANCIAMINIMA && valorIngresado<=DISTANCIAMAXIMA){
                    return valorIngresado;
                }else {
                    System.out.println("Numero ingresado no valido (No esta dentro del rango)");
                }
            }else {
                System.out.println("Dato ingresado no valido");
                scanner.next();
            }
        }
    }

    /**
     * Metodo utilizado para verificar que un valor ingresado sea valido
     * @param scanner -> es un parametro
     * @param mensaje -> envia un mensaje a terminal
     * @return -> int
     */
    public int validarTipoDeServicio(Scanner scanner, String mensaje){
        int valorIngresado;
        while (true){
            System.out.println("1) Estándar \n2) Express");
            System.out.println(mensaje);
            if (scanner.hasNextInt()){
                valorIngresado=scanner.nextInt();
                return valorIngresado;
            }else {
                System.out.println("Valor ingresado no valido");
                scanner.next();
            }
        }
    }

    /**
     * Metodo que tranforma un valor String a un valor boolean
     * @param scanner -> es un parametro
     * @param mensaje -> envia un mensaje a terminal
     * @return -> boolean
     */
    public boolean validarZonaRemota(Scanner scanner, String mensaje){
        String input;
        while (true){
            System.out.println(mensaje);
            input=scanner.next();
            if (input.equals("NO") || input.equals("no") || input.equals("No")){
                return false;
            }else {
                return true;
            }
        }
    }

}