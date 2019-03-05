/*
 * Developed by Carles Ramos
 */

package testexamen;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class TestExamen{
    public TestExamen(){
        ArrayList<GregorianCalendar>fechas = new ArrayList<GregorianCalendar>();
        GregorianCalendar fecha2 = new GregorianCalendar();
        String fecha = "15/02/1982";
        Scanner lec = new Scanner(System.in);
        GregorianCalendar fechaNac = new GregorianCalendar(1982,8,15);
        GregorianCalendar fechaNac1 = new GregorianCalendar(1992,8,15);
        GregorianCalendar fechaNac2 = new GregorianCalendar(2000,8,15);
        GregorianCalendar fechaNac3 = new GregorianCalendar(1980,8,15);
        GregorianCalendar fechaNac4 = new GregorianCalendar(1978,8,15);
        GregorianCalendar fechaNac5 = new GregorianCalendar(1970,8,15);
        GregorianCalendar fechaNac6 = new GregorianCalendar(1999,8,15);
        System.out.println(getEdad(fechaNac));
        do{
            System.out.print("fechaNacimiento: ");
            fecha = lec.nextLine();
        }while(!testFecha(fecha));
        fecha2 = puto(fecha);
        System.out.print("edad: " + getEdad(fecha2));
        fechas.add(fechaNac1);
        fechas.add(fechaNac2);
        fechas.add(fechaNac3);
        fechas.add(fechaNac4);
        fechas.add(fechaNac5);
        fechas.add(fechaNac6);
        GregorianCalendar desde = new GregorianCalendar(1975,1,1);
        GregorianCalendar hasta = new GregorianCalendar(2000,1,1);
        for (int i=0; i<fechas.size(); i++){
            if (fechas.get(i).before(hasta) && fechas.get(i).after(desde)){
                System.out.println("\n" +getEdad(fechas.get(i)));
            }
        }
    }

    public int getEdad(GregorianCalendar gc) {
        LocalDate ahora = LocalDate.now();
        LocalDate cumple;
        Period edad;
        int años = gc.get(Calendar.YEAR);
        int meses = gc.get(Calendar.MONTH)+1;
        int dias = gc.get(Calendar.DAY_OF_MONTH);
        cumple = LocalDate.of(años,meses,dias);
        edad = Period.between(cumple,ahora);
        return edad.getYears();
    }
    public boolean testFecha(String fecha){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            df.parse(fecha);
            return true;
        } catch (ParseException e) {
            System.out.println("Fecha incorrecta....");
            return false;
        }
    }

    public GregorianCalendar puto(String fecha){
        GregorianCalendar gc = new GregorianCalendar();
        Date date = null;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = df.parse(fecha);
        } catch (ParseException e) {

        }
        gc.setTime(date);
        return gc;
    }
}
