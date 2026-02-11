/**
 * @author Salgado Uresti Rene Alejandro - 2E
 */
public class Persona {

    /**
     * Declaracion de variables
     */
    private int id;
    private String name;
    private boolean isActive;

    /**
     * Constructor con parametros
     * @param id -> int (Almacena el ID)
     * @param name -> String (Almacena el nombre)
     */
    public Persona(int id, String name){
        this.id=id;
        this.name=name;
        this.isActive=true;
    }

    /**
     * Getters and Setters
     * @return -> variables (String, int, boolean)
     */
    public int getId() {return id;}
    public void setName(String name) {this.name = name;}
    public boolean isActive() {return isActive;}
    public void setActive(boolean isActive) {this.isActive = isActive;}

    /**
     * Metodo toString para imprimir arrays
     * @return -> impresion en terminal
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPersona\n");
        sb.append("ID: ").append(id);
        sb.append("\nName: ").append(name);
        sb.append("\nIs active? :").append(isActive);
        sb.append("");
        return sb.toString();
    }
}