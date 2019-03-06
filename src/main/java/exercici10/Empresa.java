package exercici10;

import utils.Lib;

import javax.management.NotCompliantMBeanException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Empresa {
    private ArrayList <Empleado> empleados;
    private static int puntero = 0;
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
        int dni = 0;
        String nom;
        String cognom;
        GregorianCalendar fechaNac = new GregorianCalendar();
        String fecha = "";
        float sueldo = 0;
        int edadHijo = 0;
        String nombreHijo = "";
        char siOno;
        Empleado empleado;
        int numHijos = 0;
        boolean esCorrecte = false;
        do {
            System.out.print("Introduzca el número de DNI: ");
            try{
                dni = Integer.parseInt(lec.nextLine());
                esCorrecte = true;
                if (dni < 10000000 || dni > 99999999){
                    System.out.println("No puede haber dni con ese numero...");
                    esCorrecte = false;
                }
            }
            catch (NumberFormatException nfe){
                Lib.mensajeError();
                esCorrecte = false;
            }
        }while (!esCorrecte);
        nif = dni+Lib.calcularletraDni(dni);
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
            empleado = new Empleado(nif, nom, cognom, fechaNac, sueldo);
            esCorrecte = false;
            do {
                System.out.print("Tiene hijos? introduce s ó n: ");
                try {
                    siOno = lec.next().charAt(0);
                    lec.nextLine();
                    if (siOno == 's' || siOno == 'S'){
                        do{
                            System.out.print("Cuantos hijos desea añadir?:");
                            try {
                                numHijos = Integer.parseInt(lec.nextLine());
                                esCorrecte = true;
                            }
                            catch (NumberFormatException nfe){
                                System.out.println("Dato incorrecto...");
                                Lib.continuar();
                                esCorrecte = false;
                            }
                        }while(!esCorrecte);
                        for (int i=0; i<numHijos; i++) {
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
                            } while (!esCorrecte);
                            Hijo aux = new Hijo(nombreHijo, edadHijo);
                            empleado.addHijo(aux);
                            empleados.add(empleado);
                        }
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

    public void  añadirEmpleadoAleatorios(){
        String [] nif ={"53215474y","52314578p","12457845v","45789865d","24378495s","34768798q"};
        String [] nombre = {"pepe","juan","paco","juanito","esperanza","juana","Micaela","jacinta"};
        String [] cognom = {"Ramos","Perez","fernandez","Trillo","Morata","Rojas","Martinez"};
        Empleado empleadoAux;
        Hijo hijoAux;
        int [] edadHijo = {1,3,4,12,2,7,9,8,6,11,10};
        GregorianCalendar [] fechaNac = {new GregorianCalendar(1990,1,3),new GregorianCalendar(1985,12,23)
        ,new GregorianCalendar(2000,4,18),new GregorianCalendar(2001,10,25)};
        float [] sueldo = {2000f,1980f,4500f,2500f,13000f,1250f,1000f};
        for (int i=0; i<nif.length; i++){
            empleadoAux = new Empleado(nif[i],nombre[Lib.random(0,nombre.length-1)],cognom[Lib.random(0,cognom.length-1)],
            fechaNac[Lib.random(0,fechaNac.length-1)],sueldo[Lib.random(0,sueldo.length-1)]);
            empleados.add(empleadoAux);
            puntero++;
            for(int z=0; z<Lib.random(0,3);z++){
                hijoAux = new Hijo(nombre[Lib.random(0,nombre.length-1)],edadHijo[Lib.random(0,edadHijo.length-1)]);
                empleadoAux.addHijo(hijoAux);
            }
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

    public void  buscarPorNif(){
        String nif = "";
        boolean esCorrecto = false;
        int posicion = 0;
        do {
            System.out.print("Introduzca el nif: ");
            nif = lec.nextLine();
        }while (!validarNif(nif));
        for (int i=0; i<empleados.size(); i++){
            if (empleados.get(i).getNif().equalsIgnoreCase(nif)){
                esCorrecto = true;
                posicion = i;
            }
        }
        if (esCorrecto){
            System.out.println(empleados.get(posicion).toString());
            Lib.continuar();
        }
        else{
            System.out.println("ningun empleado con ese nif....");
            Lib.continuar();
        }
    }

    public void buscarPorNombre(){
        String nombreU = "";
        boolean esta = false;
        System.out.print("Introduzca el nombre: ");
            nombreU = lec.nextLine();
        for (int i=0; i<empleados.size(); i++){
            try {
                if (empleados.get(i).getNom().substring(0, nombreU.length()).equalsIgnoreCase(nombreU)) {
                    esta = true;
                    System.out.println(empleados.get(i).toString());
                }
            }
            catch(StringIndexOutOfBoundsException soobe){

            }
        }
        if (!esta){
            System.out.println("ningun empleado con ese nombre....");
            Lib.continuar();
        }
    }

    public void buscarPorRangoFecha(){
        String fecha1 = "";
        String fecha2 = "";
        GregorianCalendar fechaNac1 = new GregorianCalendar();
        GregorianCalendar fechaNac2 = new GregorianCalendar();
        boolean esCorrecte = false;
        do {
            System.out.print("Introduce la primera fecha: ");
            fecha1 = lec.nextLine();
            if (comprovarFecha(fecha1) == false){
                System.out.println("Fecha incorecta...");
                Lib.continuar();
                esCorrecte = false;
            }
            else {
                fechaNac1 = convertirFecha(fecha1);
                esCorrecte = true;
            }
        }while (!esCorrecte);
        esCorrecte = false;
        do {
            System.out.print("Introduce la segunda fecha: ");
            fecha1 = lec.nextLine();
            if (comprovarFecha(fecha1) == false){
                System.out.println("Fecha incorecta...");
                Lib.continuar();
                esCorrecte = false;
            }
            else {
                fechaNac2 = convertirFecha(fecha1);
                esCorrecte = true;
            }
        }while (!esCorrecte);

        for (int i=0; i<empleados.size(); i++){
            if (empleados.get(i).getFechaNac().after(fechaNac1)
            && empleados.get(i).getFechaNac().before(fechaNac2)){
                System.out.println(empleados.get(i).toString());
            }
        }
    }

    public void buscarPorRangoSueldo(){
        float sueldo1 = 0;
        float sueldo2 = 0;
        boolean esCorrecto = false;

        do{
            System.out.print("Desde: ");
            try{
                sueldo1 = Float.parseFloat(lec.nextLine());
                esCorrecto = true;
            }
            catch(NumberFormatException nfe){
                System.out.println("Dato incorrecto...");
                esCorrecto = false;
            }
        }while (!esCorrecto);
        do{
            System.out.print("Hasta: ");
            try{
                sueldo2 = Float.parseFloat(lec.nextLine());
                esCorrecto = true;
            }
            catch(NumberFormatException nfe){
                System.out.println("Dato incorrecto...");
                esCorrecto = false;
            }
        }while (!esCorrecto);
        for (int i=0; i<empleados.size(); i++){
            if (empleados.get(i).getSueldo()>=sueldo1 && empleados.get(i).getSueldo()<=sueldo2){
                System.out.println(empleados.get(i).toString());
            }
        }
    }

    public void buscarPorHijosMenores(){
        for (int i=0; i<empleados.size(); i++){
            for (int z=0; z<empleados.get(i).getSize(); z++){
                if (empleados.get(i).getHijo(z).getEdad()<18){
                    System.out.println(empleados.get(i));
                }
            }

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
        DateFormat dF = new SimpleDateFormat("dd/MM/yyyy");
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

    public void añadir(Empleado e){
        empleados.add(e);
        puntero++;
    }

}
