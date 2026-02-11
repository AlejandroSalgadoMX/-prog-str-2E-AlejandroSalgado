import java.util.Scanner;



public class App {
    public static void main(String[] args) throws Exception {

        int opc;
        Scanner sc= new Scanner(System.in);
        PersonaService personaService= new PersonaService();
        Persona[] personas = new Persona[3];

        do{
            System.out.println("===Menu===");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID ");
            opc=sc.nextInt();
            switch (opc) {
                case 1:
                    personaService.alta(personas, sc);
                    break;
                default:
                    System.out.println("Opcion invalida");
            }


        }while(opc!=0);






    }
}
