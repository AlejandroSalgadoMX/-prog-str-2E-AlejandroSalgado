import java.util.Scanner;

/**
 * Clase principal Main despliega un menu interactivo en terminal, que permite ingresar la opcion deseada y muestra
 * lo que se ejecuta dependiendo de la opcion seleccionada.
 * @author Salgado Uresti Rene Alejandro - 2E
 */
public class Main {
    public static double CONSTANTE1Centigrados=1.8;
    public static double CONSTANTE2Centigrados=32;
    public static double PI=3.141621;

    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular área de un circulo");
            System.out.println("5. Salir");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Calcular IMC.");
                    double pesoKg= obtenerDouble(sc,"Ingresa el peso en KG");
                    double alturaM= obtenerDouble(sc,"Ingresa la altura en M -> 1.80");

                    double IMC= calcularIMC(pesoKg,alturaM);
                    System.out.println("IMC: "+IMC);

                    break;
                case 2:
                    System.out.println("Calcular área de un rectángulo.");
                    double baseRectangulo= obtenerDouble(sc,"Ingresa el peso en KG");
                    double alturaRectangulo= obtenerDouble(sc,"Ingresa la altura en M -> 1.80");
                    double areaRectangulo=calcularAreaRectangulo(baseRectangulo,alturaRectangulo);
                    System.out.println("Area: "+areaRectangulo);

                    break;
                case 3:
                    System.out.println("Convertir °C a °F");
                    double gradosCentigrados= obtenerDouble(sc,"Introduce los grados °C ");
                    double gradosFarenheit=convertirGrados(gradosCentigrados);

                    System.out.println("° "+gradosFarenheit);

                    break;
                case 4:
                    System.out.println("Calcular área de un circulo");
                    double radio=obtenerDouble(sc,"Ingresa el radio de tu circulo");
                    double areaCirculo=calcularAreaCirculo(radio);
                    System.out.println("El area es: "+areaCirculo);
                    break;
                case 5:
                    System.out.println("Hasta luego...");
                    break;
                default:
                    System.out.println("Opcion invalida, intenta de nuevo");
            }
            System.out.println();

        } while (choice != 5);

    }

    /**  Metodo que retorna un valor capturado por terminal
     * * @param sc -> previamente declarado en main
     * * @param mensaje -> es un parametro
     * * @return -> double
     * */
    public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    /**  Metodo que devuelve el IMC con formula -> peso/altura²
     * * @param pesoKg -> expresado en Kilos
    * * @param alturaM -> expresado en Metros
    * * @return -> double de IMC
    * */
    public static double calcularIMC(double pesoKg, double alturaM){
        return pesoKg/(alturaM*alturaM);
    }

    /**
     * * Metodo que devuelve el Area de un Rectangulo
     * * @param baseRectangulo -> expresado en metros
     * * @param alturaRectangulo -> expresado en metros
     * * @return -> double de areaRectangulo
     * */
    public static double calcularAreaRectangulo(double baseRectangulo, double alturaRectangulo){
        return baseRectangulo*alturaRectangulo;
    }

    /** Metodo que convierte grados Centigrados a Farenheit
     * *@param gradosCentigrados -> Expresado en grados centigrados
     * * @return -> double de gradosFarenheit
     * */
    public static double convertirGrados(double gradosCentigrados){
        return (gradosCentigrados*CONSTANTE1Centigrados)+CONSTANTE2Centigrados;
    }

    /** Metodo que calcula el area de un circulo por medio de la formula PI*radio²
     * * @param radio -> Expresado en metros
     * * @return -> double de areaCirculo
     * */
    public static double calcularAreaCirculo(double radio){
        return (radio*radio)*PI;
    }

}
