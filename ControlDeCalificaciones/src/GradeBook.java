public class GradeBook {

    /**
     * Variables locales usadas para almacenar el return de los metodos de la clase GradeService e impimirlos
     */
    private String  state;
    private double average;
    private double finalNote;

    /**
     * Constructor vacio
     */
    public GradeBook(){
    }

    /**
     * Instancia de la clase GradeService
     */
    GradeService gradeService1=new GradeService();

    /**
     * Metodo que realiza el proceso de los metodos de GradeService y almacena el return en variables locales
     * @param note1 -> double (Parcial 1)
     * @param note2 -> double (Parcial 2)
     * @param note3 -> double (Parcial 3)
     * @param assistance -> int (Porcentaje de asistencia)
     * @param project -> boolean (¿Entrego proyecto?)
     */
    protected void process(double note1, double note2, double note3 , int assistance, boolean project){
        average=gradeService1.calculateAverage(note1,note2,note3);
        finalNote=gradeService1.calculateFinalNote(average, assistance);
        state=gradeService1.validationState(finalNote, assistance,project);
    }

    /**
     * Metodo que imprime la boleta final del alumno
     * @param studentName -> String (Nombre del estudiante)
     * @param note1 -> double (Parcial 1)
     * @param note2 -> double (Parcial 2)
     * @param note3 -> double (Parcial 3)
     * @param assistance -> int (Porcentaje de asistencia)
     * @param project -> boolean (¿Entrego proyecto?)
     */
    protected void printGradeBook(String studentName, double note1, double note2, double note3, int assistance, boolean project){
        System.out.println("\n========================================");
        System.out.println("           REPORTE FINAL                ");
        System.out.println("========================================");
        System.out.println("Alumno:       "+studentName);
        System.out.printf("Parciales:    %.1f,    %.1f,    %.1f\n",note1,note2,note3);
        System.out.printf("Promedio:     %.2f\n",average);
        System.out.println("Asistencia:   " + assistance + "%");
        System.out.println("Proyecto:     " + (project ? "SÍ" : "NO"));
        System.out.printf("Nota Final:   %.2f\n", finalNote);
        System.out.println("ESTADO:       " + state);
        System.out.println("========================================");
    }
}
