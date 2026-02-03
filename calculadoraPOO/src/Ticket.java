public class Ticket {

        /**
         * Constantes usadas para calcular el precio y descuento
         */
        private double  DESCUENTO=0.10;
        private double PRECIO=10;

        /**
         * Variables utilizadas para retornar valores
         */
        public double subtotal;
        public double descuentoCalculado;
        public double total;


        /**
         * Constructor vacio
         */
        public Ticket(){

        }

        /**
         * Metodo que hace uso de los metodos privados y los retorna a (App)
         * @param cantidad - Valor ingresado por el usuario
         */
        public void procesar(int cantidad){
                calcularSubtotal(cantidad);
                calcularDescuento(this.subtotal);
                calcularTotal(this.subtotal);
        }

        /**
         * Metodo que calcula el subtotal de una compra
         * @param cantidad - Ingresado por el usuario
         */
        private void calcularSubtotal(int cantidad){
            this.subtotal=cantidad*PRECIO;
        }

        /**
         * Metodo que calcula el descuento
         * @param subtotal - Se calcula anterioremente para poder calcular nuestro descuento
         */
        private void calcularDescuento(double subtotal){
                this.descuentoCalculado=this.subtotal*DESCUENTO;
        }

        /**
         * Metodo que calcula el total con descuento aplicado
         * @param subtotal - Parametro usado para calcular el total con el descuento aplicado
         */
        private void calcularTotal(double subtotal){
                this.total= this.subtotal-this.descuentoCalculado;
        }

        /**
         * Metodo que imprime el ticket con los valores calculados
         * @param cantidad -> es un parametro
         */
        public void imprimirTicket(int cantidad){
                System.out.println("----Ticket----");
                System.out.println("Cantidad de productos: "+cantidad);
                System.out.println("Subtotal: "+subtotal);
                System.out.println("Descuento calculado: "+descuentoCalculado);
                System.out.println("Total: "+total);
                System.out.println("----Ticket-----");
        }

}
