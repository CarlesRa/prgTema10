package exercici10;

import utils.Lib;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Empresa {
    private ArrayList <Empleado> empleados;
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
        Hijo hijo = new Hijo();
        int edadHijo = 0;
        String nombreHijo = "";
        char siOno;
        Empleado empleado;
        boolean esCorrecte = false;
        do {
            System.out.print("Introduzca el nif: ");
            nif = lec.nextLine();
            if (nif.length() != 9 || Character.isLetter(nif.charAt(8)) == false){
                System.out.println("Dni no valido...");
                Lib.continuar();
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
                } catch (NumberFormatException nfe) {
                    System.out.println("Dato incorrecto...");
                    esCorrecte = false;
                }
            }while (!esCorrecte);
            do {
                System.out.print("Tiene hijos? introduce s ó n: ");
                try {
                    siOno = lec.next().charAt(0);
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
                        hijo = new Hijo(nombreHijo,edadHijo);
                        empleado = new Empleado(nif,nom,cognom,fechaNac,sueldo,hijo);
                        empleados.add(empleado);
                        System.out.println("Empleado añadido con exito!!");
                        Lib.continuar();
                        esCorrecte = true;
                    }
                    else if (siOno == 'n' || siOno == 'N'){
                        empleado = new Empleado(nif,nom,cognom,fechaNac,sueldo);
                        empleados.add(empleado);
                        System.out.println("Empleado añadido con exito!!");
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
}
