import java.util.Scanner;

public class Main {
    public static int LIMITESUPERIOR=5;
    public static int CONTADORTOTAL=0;
    public static int CONTADORCAF=0;
    public static int CONTADORFAC=0;
    public static int CONTADORKMAMI=0;
    public static int CONTADORMIAKM=0;
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion=1;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion){
                    case 1:
                        double centigrados= validarDouble(sc,"Ingresa los °C: ");
                        CONTADORTOTAL++;
                        CONTADORCAF++;
                        break;
                    case 2:
                        double farenheit=validarDouble(sc,"Ingresa los °F: ");
                        CONTADORFAC++;
                        CONTADORTOTAL++;
                        break;
                    case 3:
                        CONTADORKMAMI++;
                        CONTADORTOTAL++;
                        break;
                    case 4:
                        CONTADORMIAKM++;
                        CONTADORTOTAL++;
                        break;
                    case 5:
                        System.out.println("Cerrando programa...");
                        break;
                    default:
                        System.out.println("Opción invalida, intente nuevamente");
                        break;
                }



        }while (opcion!=LIMITESUPERIOR);


    }

    public static double validarDouble(Scanner sc, String mensaje){
        while (true){
            System.out.println(mensaje);
            if(sc.hasNextDouble()){
                sc.nextDouble();
            }else {
                System.out.println("Valor ingresado no valido");
                sc.nextDouble();
            }
        }

    }

    public static void mostrarMenu(){
        System.out.println("-----Menu de conversión-----");
        System.out.println("1) °C a °F");
        System.out.println("2) °F a °C");
        System.out.println("Km a Millas");
        System.out.println("Millas a Km");
        System.out.println("Salir");
    }

}

