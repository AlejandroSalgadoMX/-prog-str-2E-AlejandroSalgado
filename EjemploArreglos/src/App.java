public class App {
    public static void main(String[] args) throws Exception {

        int[] arr;//Declaracion
        arr = new int[5]; //Incializado
        int[] arr1 = new int[4]; //Declaracion + Inicializacion
        int[] arr2 = {1, 2, 3, 4}; //Declaracion e Incializacion de 4 elementos conocidos

//Get
        System.out.println(arr[0]);

        System.out.println(arr[1]);
//Set
        arr[0] = 5;
        System.out.println(arr[0]);
//System.out.println(arr[5]);
        System.out.println("__________________-");
//Recorrido
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("---for each---");
        for (int num : arr) {
            System.out.println(num);
        }

        Persona[] personas = new Persona[3];

        Persona persona1 = new Persona();
        Persona persona2 = new Persona(2, "David");
        Persona persona3 = new Persona(3, "Rene");
        personas[0] = persona1;
        personas[1] = persona2;
        personas[2] = persona3;

        personas[0] = null;
        System.out.println("______personas______");
        for (Persona persona : personas) {
            try {
                System.out.println("------");
                System.out.println(persona.getId());
                System.out.println(persona.getName());
                System.out.println(persona.isActive());
            } catch (Exception e) {
                System.out.println("Hay un null");
            }

//System.out.println(persona);
        }
    }
}