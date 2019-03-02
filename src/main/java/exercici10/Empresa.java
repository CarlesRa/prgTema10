package exercici10;

import utils.Lib;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Empresa {
    private ArrayList <Empleado> empleados;
    private int puntero = 0;
    private Scanner lec = new Scanner(System.in);
    public Empresa() {
        this.empleados = new ArrayList<>();
    }

    public Empleado getEmpleado(int p) {
        return empleados.get(p);
    }


    //metodes
    public void nuevoEmpleado() {
        String nif;
        String nom;
        String cognom;
        GregorianCalendar fechaNac = new GregorianCalendar();
        String fecha = "";
        float sueldo = 0;
        int edadHijo = 0;
        String nombreHijo = "";
        char siOno;
        Empleado empleado;
        boolean esCorrecte = false;
        do {
            System.out.print("Introduzca el nif: ");
            nif = lec.nextLine();
            if (!validarNif(nif)){
                esCorrecte = false;
            }
            else {
                esCorrecte = true;
            }
        }while (!esCorrecte);
        for (int i=0; i<empleados.size(); i++){

            if (empleados.get(i).getNif().equalsIgnoreCase(nif)){
                esCorrecte = false;
            }

        }
        if (esCorrecte){
            esCorrecte = false;
            System.out.print("Introduce el nombre: ");
            nom = lec.nextLine();
            System.out.print("Introduce el apellido: ");
            cognom = lec.nextLine();
            do {
                System.out.print("Introduce la fecha de nacimiento: ");
                fecha = lec.nextLine();
                if (comprovarFecha(fecha) == false){
                    System.out.println("Fecha incorecta...");
                    Lib.continuar();
                    esCorrecte = false;
                }
                else {
                    fechaNac = convertirFecha(fecha);
                    esCorrecte = true;
                }

            }while (!esCorrecte);
            do {
                System.out.print("Introduce el sueldo: ");
                try {
                    sueldo = Float.parseFloat(lec.nextLine());
                    esCorrecte = true;
                } catch (NumberFormatException nfe) {
                    System.out.println("Dato incorrecto...");
                    esCorrecte = false;
                }
            }while (!esCorrecte);
            do {
                System.out.print("Tiene hijos? introduce s ó n: ");
                try {
                    siOno = lec.next().charAt(0);
                    lec.nextLine();
                    if (siOno == 's' || siOno == 'S'){
                        System.out.print("Introduce el nombre del hijo: ");
                        nombreHijo = lec.nextLine();
                        System.out.print("Introduce la edad: ");
                        do {
                            try {
                                edadHijo = Integer.parseInt(lec.nextLine());
                            } catch (NumberFormatException nfe2) {
                                System.out.println("Dato incorrecto...");
                                esCorrecte = false;
                            }
                        }while (!esCorrecte);
                        Hijo aux = new Hijo(nombreHijo,edadHijo);
                        empleado = new Empleado(nif,nom,cognom,fechaNac,sueldo,aux);
                        empleados.add(empleado);
                        System.out.println(empleados.get(puntero).toString());
                        System.out.println("Empleado añadido con exito!!");
                        Lib.continuar();
                        puntero++;
                        esCorrecte = true;
                    }
                    else if (siOno == 'n' || siOno == 'N'){
                        empleado = new Empleado(nif,nom,cognom,fechaNac,sueldo);
                        empleados.add(empleado);
                        System.out.println(empleados.get(puntero).toString());
                        System.out.println("Empleado añadido con exito!!");
                        puntero++;
                        Lib.continuar();
                        esCorrecte = true;
                    }
                    else{
                        System.out.println("Opcion incorrecta...");
                        Lib.continuar();
                        esCorrecte = false;
                    }
                }
                catch (InputMismatchException imme){
                    esCorrecte = false;
                }

            }while (!esCorrecte);
        }
        else{
            System.out.println("El empleado ya esta en la base de datos...");
        }

    }

    public void nuevoHijo(){
        String nif = "";
        String nombre = "";
        int edad = 0;
        Hijo hijo;
        boolean esCorrecto = false;
        do{
            System.out.print("Introduzca el nif: ");
            nif = lec.nextLine();
        }while (!validarNif(nif));

        for (int i=0; i<empleados.size(); i++){
            if (empleados.get(i).getNif().equalsIgnoreCase(nif)){
                System.out.print("Introduzca el nombre: ");
                nombre = lec.nextLine();
                do{
                    System.out.print("introduzca la edad: ");
                    try{
                        edad = Integer.parseInt(lec.nextLine());
                        esCorrecto = true;
                    }
                    catch (NumberFormatException nfe){
                        System.out.println("Dato incorrecto...");
                        esCorrecto = false;
                        Lib.continuar();
                    }
                }while (!esCorrecto);
                hijo = new Hijo(nombre,edad);
                try {
                    empleados.get(i).addHijo(hijo);
                    esCorrecto = true;
                }
                catch (NullPointerException npe){

                }
                System.out.println(empleados.get(i).toString());
            }
        }
        if (esCorrecto){
            System.out.println("Hijo añadido con exito!!");
        }
        else{
            System.out.println("ningun empleado con ese nif en la database...");
        }
    }

    public void modificarSueldo(){
        String nif = "";
        float sueldo = 0;
        boolean esCorrecto = false;
        do {
            System.out.print("Introduzca el nif: ");
            nif = lec.nextLine();
        }while (!validarNif(nif));
        for (int i=0; i<empleados.size(); i++){
            if (empleados.get(i).getNif().equals(nif)){
                do{
                    System.out.print("Introduzca el nuevo sueldo: ");
                    try{
                        sueldo = Float.parseFloat(lec.nextLine());
                        esCorrecto = true;
                    }
                    catch (NumberFormatException nfe2){
                        System.out.println("Dato incorrecto...");
                        esCorrecto = false;
                    }
                }while (!esCorrecto);
                empleados.get(i).setSueldo(sueldo);
            }
        }
    }

    public  void  borrarEmpleado(){
        String nif = "";
        boolean esCorrecto = false;
        do {
            System.out.print("Introduzca el nif: ");
            nif = lec.nextLine();
        }while (!validarNif(nif));
        for (int i=0; i<empleados.size(); i++){
            if (empleados.get(i).getNif().equalsIgnoreCase(nif)){
                empleados.remove(i);
                puntero--;
                esCorrecto = true;
            }
        }
        if (esCorrecto){
            System.out.println("Empleado borrado con exito!!");
            Lib.continuar();
        }
        else{
            System.out.println("ningun empleado con ese nif....");
            Lib.continuar();
        }
    }

    public  void  borrarHijo(){
        String nif = "";
        boolean esCorrecto = false;
        int posicion = 0;
        String nombreHijo = "";
        do {
            System.out.print("Introduzca el nif: ");
            nif = lec.nextLine();
        }while (!validarNif(nif));
        for (int i=0; i<empleados.size(); i++){
            if (empleados.get(i).getNif().equalsIgnoreCase(nif)){
                System.out.println("Introduce el nombre del hijo: ");
                nombreHijo = lec.nextLine();
                for (int z=0; z<empleados.get(i).getSize(); z++){
                    if (empleados.get(i).getHijo(z).getNom().equalsIgnoreCase(nombreHijo)){
                        empleados.get(i).removerHiho(z);
                        esCorrecto = true;
                    }
                }
            }
        }
        if (esCorrecto){
            System.out.println("Hijo eliminado con exito!!");
            Lib.continuar();
        }
        else{
            System.out.println("ningun empleado con ese nif....");
            Lib.continuar();
        }
    }


    public boolean comprovarFecha(String fecha){
        try{
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            format.setLenient(false);
            format.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    public GregorianCalendar convertirFecha(String fecha)  {
        DateFormat dF = new SimpleDateFormat(fecha);
        Date date = null;
        try {
            date = dF.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        return  cal;
    }
    public boolean validarNif(String nif){
        if (nif.length() != 9 || Character.isLetter(nif.charAt(8)) == false){
            System.out.println("Dni no valido...");
            Lib.continuar();
            return false;
        }
        else{
            return true;
        }
    }
    public void visualizarEmpleados(){
        System.out.println(empleados);
    }

}
