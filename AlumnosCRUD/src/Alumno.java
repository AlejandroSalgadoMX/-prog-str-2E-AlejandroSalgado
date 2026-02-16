public class Alumno {

    /**
     * Declaracion de variables
     */
    private int id;
    private String name;
    private double grade;
    private boolean isActive;

    /**
     * Constructor con parametros
     * @param id -> int
     * @param name -> String
     * @param grade -> double
     */
    public Alumno(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.isActive = true;
    }

    /**
     * Getters and Setters
     * @return variables (int, String, double, boolean)
     */
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public double getGrade() {return grade;}
    public void setGrade(double grade) {this.grade = grade;}
    public boolean isActive() {return isActive;}
    public void setActive(boolean active) {isActive = active;}

    /**
     * Metodo para imprimir arreglos
     * @return -> Impresion en terminal
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nAlumno\n");
        sb.append("ID: ").append(id);
        sb.append("\nName: ").append(name);
        sb.append("\nAverage: ").append(grade);
        sb.append("\nIs active? :").append(isActive);
        sb.append("");
        return sb.toString();
    }

}
