public class Ticket {

    /**
     * Metodo que despliega en terminal el ticket final
     */
    public static void imprimirTicket(){
        String servicioString = (Main.tipoDeServicio == 1) ? "Estándar" : "Express";
        String zonaRemota=(Main.esZonaRemota==true)? "SI" : "NO";
        System.out.println("============================================");
        System.out.println("-----------------Ticket---------------------");
        System.out.println("Selecciono el servicio: "+servicioString);
        System.out.println("Peso:             "+Main.pesoKG +"kg");
        System.out.println("Distancia:        "+Main.distanciaKm+"km");
        System.out.println("Es zona remota:   "+zonaRemota);
        System.out.println("Subtotal:        $"+ Main.subTotal);
        System.out.println("IVA:             $"+ Main.IVACalculado);
        System.out.println("Total:           $"+ Main.totalFinal);
        System.out.println("============================================");
    }

}