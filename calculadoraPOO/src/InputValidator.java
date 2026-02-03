import java.util.Scanner;

public class InputValidator {

    /**
     * Metodo que valida un numero ingresado por usuario
     * @param mensaje -> es un parametro
     * @param sc -> es un parametro (envia un mensaje a terminal)
     * @return -> int
     */
    public int obtenerNumeroEntero(String mensaje, Scanner sc){
        int valor;
        while (true){
            System.out.println(mensaje);
            if(sc.hasNextInt()){
                valor= sc.nextInt();
                if (valor>0){
                    return valor;
                }else {
                    System.out.println("Numero ingresado no valido (Solo numeros mayores que 0)");
                }
            }else {
                System.out.println("Dato ingresado no valido");
                sc.nextLine();
            }
        }
    }


}
