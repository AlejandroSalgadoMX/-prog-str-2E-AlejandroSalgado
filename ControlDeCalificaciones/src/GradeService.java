/**
 * Clase usada para realizar los calculos de promedio(parciales) y nota final y la validacion de (Aprobado - Reprobado)
 * @author Salgado Uresti Rene Alejandro - 2E
 */
public class GradeService {

    /**
     * Constantes usadas para verifcar el estado del alumno
     */
    private final double LIMITFINALNOTE=70;
    private final int LIMITASSISTANCE=80;

    /**
     * Constructor vacio
     */
    public GradeService(){}

    /**
     * Metodo que calcula el promedio de 3 parciales
     * @param note1 -> double (Parcial 1)
     * @param note2 -> double (Parcial 2)
     * @param note3 -> double (Parcial 3)
     * @return -> double
     */
    protected double calculateAverage(double note1, double note2, double note3) {
        return (note1+note2+note3)/3;
    }

    /**
     * Metodo que calcula la nota final aplicando porcentaje al promedio y a la asistencia
     * @param average -> double (Anteriormente calculado)
     * @param assistance -> int (porcentaje de asistencia)
     * @return -> double
     */
    protected double calculateFinalNote(double average, int assistance){
        return (average*0.7)+(assistance *0.3);
    }

    /**
     * Metodo que valida el estado final del alumno (Aprobado - Reprobado)
     * @param finalNote -> double (calculado anteriormente)
     * @param assistance -> int (porcentaje de asistencia)
     * @param project -> boolean (proyecto entregado TRUE - FALSE)
     * @return -> String (APROBADO - REPROBADO.... )
     */
    protected String validationState(double finalNote, int assistance, boolean project){
        if (assistance <LIMITASSISTANCE){
            return "REPROBADO por asistencias";
        }else {
            if (!project){
                return "REPROBADO por proyecto";
            }else {
                if(finalNote>LIMITFINALNOTE){
                    return "APROBADO";
                }else {
                    return "REPROBADO por promedio";
                }
            }
        }
    }

}