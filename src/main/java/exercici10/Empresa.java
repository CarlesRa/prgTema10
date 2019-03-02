package exercici10;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Empresa {
    private ArrayList <Empleado> empleados;
    private Scanner lec = new Scanner(System.in);
    public Empresa() {
        this.empleados = new ArrayList<>();
    }

    public Empleado getEmpleado(int p) {
        return empleados.get(p);
    }
    public void addEmpleado(Empleado empleado){
        empleados.add(empleado);
    }
    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    //metodes
    public void nuevoEmpleado(){
        String nif;
        String nom;
        String cognom;
        GregorianCalendar fechaNac;
        float sueldo;
        Hijo hijo;
        boolean esCorrecte = false;
        do {
            System.out.print("Introduzca el nif: ");
            nif = lec.nextLine();
            if (nif.length() != 9 || Character.isLetter(nif.charAt(8)) == false){
                esCorrecte = false;
            }
            else {
                esCorrecte = true;
            }
        }while (!esCorrecte);
    }
}
