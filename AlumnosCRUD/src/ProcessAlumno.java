import com.sun.nio.sctp.PeerAddressChangeNotification;

import java.util.Scanner;

public class ProcessAlumno {

    //Instancia de InputValidator
    InputValidator validator=new InputValidator();

    /**
     * Declaracion de variables constantes
     */
    private final double validateGradeHigher=8.0;
    private final int validateCount=0;

    /**
     * Metodo para dar de alta y llenar un arreglo
     * @param alumnos -> arreglo
     * @param scanner -> Declarado en Main
     */
    protected void up(Alumno[] alumnos, Scanner scanner){
        String name="";
        int id=validator.validateIntId(scanner,"Ingresa el ID de la persona: ");
        if (id<=0){
            System.out.println("No se admiten valor menores o iguales a 0");
            return;
        } else if (verifyID(id,alumnos)) {
            System.out.println("ID no valido, ya existe");
            return;
        } else {
            System.out.println("Ingresa el nombre de la persona: ");
            name=scanner.next();
            if (name.isBlank()){
                System.out.println("No se admite un nombre vacio");
                scanner.next();
            }
        }
        double grade=validator.validateDoubleGrade(scanner, "Ingresa el promedio del alumno: ");
        int indiceInsercion=getIndex(alumnos);
        if (indiceInsercion==-1){
            System.out.println("El arreglo esta lleno");
            return;
        }
        Alumno alumno1=new Alumno(id,name,grade);
        alumnos[indiceInsercion]=alumno1;
        System.out.println("\n"+alumno1.toString());
    }


    /**
     * Metodo para verificar que un valor dentro del arreglo no exista
     * @param id -> int
     * @param alumnos -> arreglo
     * @return -> boolean
     */
    private boolean verifyID(int id, Alumno[] alumnos){

        for (Alumno alumno : alumnos) {
            if(alumno!=null && alumno.getId()==id) {
                return true;
            }
        }
        return false;
    }


    /**
     * Metodo para verificar que un espacio en el arreglo este vacio, o que no este lleno
     * @param alumnos -> arreglo
     * @return -> index (int)
     */
    private int getIndex(Alumno[] alumnos){
        for (int i = 0; i < alumnos.length; i++) {
            if(alumnos[i]==null){
                return i;
            }
        }
        return -1;
    }


    /**
     * Metodo para buscar un ID e imprime la información que contenga ese ID
     * @param alumnos -> arreglo
     * @param scanner -> declarado en Main
     */
    protected void searchID(Alumno[] alumnos, Scanner scanner){
        int id=validator.validateIntId(scanner,"Ingresa el ID a buscar:");
        boolean validateID=verifyID(id,alumnos);
        if(validateID) {
            for (Alumno alumno : alumnos) {
                if (alumno != null) {
                    if(alumno.isActive()) {
                        if (alumno.getId() == id) {
                            System.out.println(alumno.toString());
                        }
                    }else {
                        System.out.println("ID dado de baja");
                    }
                }
            }
        }else {
            System.out.println("ID no encontrado");
        }
    }

    /**
     * Metodo para cambiar un parametro boolean a (false)
     * @param alumnos -> arreglo
     * @param scanner -> declarado en Main
     */
    protected void downLogicFromID(Alumno [] alumnos,Scanner scanner){
        int id=validator.validateIntId(scanner,"Ingresa el ID para dar de baja:");
        boolean validateID=verifyID(id,alumnos);
        if(validateID) {
            for (Alumno alumno : alumnos) {
                if (alumno != null ) {
                    if(alumno.isActive()) {
                        if (alumno.getId() == id) {
                            alumno.setActive(false);
                            System.out.println(alumno.toString());
                        }
                    }else {
                        System.out.println("ID dado de baja");
                    }
                }
            }
        }else {
            System.out.println("ID no encontrado");
        }
    }


    /**
     * Metodo para imprimir los datos que están dentro del arreglo, solo si un parametro boolean es (true)
     * @param alumnos -> arreglo
     */
    protected void listActiveID(Alumno[] alumnos){
        for (Alumno alumno : alumnos){
            if (alumno!=null && alumno.isActive() ){
                System.out.println(alumno.toString());
            }
        }
    }


    /**
     * Metodo para cambiar el valor de una variable double dentro del arreglo
     * @param alumnos -> arreglo
     * @param scanner -> declarado en Main
     */
    protected void updateGradeFromID(Alumno[] alumnos, Scanner scanner){
        int id=validator.validateIntId(scanner,"Ingresa el ID del alumno a cambiar el promedio:");
        boolean validateID=verifyID(id,alumnos);
        if (validateID){
            for(Alumno alumno : alumnos){
                if (alumno!=null){
                    if (alumno.isActive()){
                        if (alumno.getId() == id) {
                            double  grade=validator.validateDoubleGrade(scanner,"Ingresa el nuevo promedio: ");
                            alumno.setGrade(grade);
                            System.out.println(alumno.toString());
                        }
                    }else {
                        System.out.println("ID dado de baja");
                    }
                }
            }
        }else {
            System.out.println("ID no encontrado");
        }
    }

    /**
     * Metodo para realizar la sumatoria de los promedios de alumnos activos,
     * asi como verificar que alumno tiene el promedio mas alto y mas bajo,
     * ademas de realizar el conteo de cuantos alumnos tienen un promedio
     * mayor o igual que 8, para despues mostrarlo en terminal
     * @param alumnos -> arreglo
     */
    protected void printReport(Alumno[] alumnos){
        double sumGrades = 0;
        int countAssets = 0;
        int countAssetWithGradeGreater8 = 0;
        Alumno higherGrade = null;
        Alumno minorGrade = null;
        for(Alumno alumno : alumnos ){
            if(alumno!=null && alumno.isActive()){
                sumGrades+=alumno.getGrade();
                countAssets++;
                if(higherGrade==null || alumno.getGrade()> higherGrade.getGrade()) {
                    higherGrade=alumno;
                }
                if(minorGrade==null || alumno.getGrade()<minorGrade.getGrade()){
                    minorGrade=alumno;
                }
                if (alumno.getGrade()>=validateGradeHigher){
                    countAssetWithGradeGreater8++;
                }
            }
        }
        if(countAssets>validateCount){
            double averageGeneral=sumGrades/countAssets;
            System.out.println("\nPromedio General de Alumnos Activos: "+averageGeneral);
            System.out.println("\nAlumno con el promedio mas alto"+higherGrade.toString());
            System.out.println("\nAlumno con el promedio mas bajo"+minorGrade.toString());
            System.out.println("\nNumero de alumnos con promedio mayor o igual que 8: "+countAssetWithGradeGreater8);
        }else {
            System.out.println("No hay alumnos activos");
        }
    }

}
