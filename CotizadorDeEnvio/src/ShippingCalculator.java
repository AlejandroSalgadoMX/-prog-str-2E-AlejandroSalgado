public class ShippingCalculator {
    /**
     * Constantes utilizadas para aplicar ciertas condiciones al subtotal
     */
    private static final double COSTOKG=12;
    private static final double TARIFAEXPRESS=90;
    private static final double TARIFAESTANDAR=50;
    private static final double TARIFAEXTRAZONAREMOTA=1.10;
    private static final int DISTANCIAMENOR=50;
    private static final int DISTANCIAMEDIA=200;
    private static final double TARIFADISTANCIAMENOR=20;
    private static final double TARIFADISTANCIAMEDIA=60;
    private static final double TARIFADISTANCIAMAYOR=120;
    private static final int SERVICIOESTANDAR=1;
    private static final int SERVICIOEXPRESS=2;

    /**
     * Constante utilizada para calcular el IVA
     */
    private static final double IVA=0.16;

    /**
     * Variables que almacenan temporalmente el resultado de los calculos
     */
    static double subtotal;
    static double ivaCalculado;

    /**
     * Metodo que calcula el subtotal aplicando ciertas condiciones
     * se mandaron a llamar las variables directamente
     * @return -> double
     */
    public static double calcularSubtotal() {
        if (Main.tipoDeServicio == SERVICIOESTANDAR) {
            subtotal = TARIFAESTANDAR;
        } else if (Main.tipoDeServicio==SERVICIOEXPRESS){
            subtotal = TARIFAEXPRESS;
        }

        subtotal += (Main.pesoKG * COSTOKG);

        if (Main.distanciaKm > DISTANCIAMEDIA) {
            subtotal += TARIFADISTANCIAMAYOR;
        } else if (Main.distanciaKm > DISTANCIAMENOR) {
            subtotal += TARIFADISTANCIAMEDIA;
        } else {
            subtotal += TARIFADISTANCIAMENOR;
        }

        if (Main.esZonaRemota) {
            subtotal *= TARIFAEXTRAZONAREMOTA;
        }
        return subtotal;

    }

    /**
     * Metodo que calcula el IVA
     * @param subtotal -> Calculado previamente (double)
     * @return -> double
     */
    public static double calcularIVA(double subtotal){
        ivaCalculado= subtotal*IVA;
        return ivaCalculado;
    }

    /**
     * Metodo para calcular el total
     * @param subtotal -> Calculado previamente
     * @param ivaCalculado -> Calculado previamente
     * @return -> double
     */
    public static double calcularTotal(double subtotal, double ivaCalculado){
        double total;
        total= ShippingCalculator.subtotal + ShippingCalculator.ivaCalculado;
        return total;
    }

}