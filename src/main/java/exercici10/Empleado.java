/*
 * Developed by Carles Ramos
 */

package exercici10;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Empleado {
    private String nif;
    private String nom;
    private String cognom;
    private GregorianCalendar fechaNac;
    private float sueldo;
    private ArrayList<Hijo>hijos;

    public Empleado(String nif, String nom, String cognom, GregorianCalendar fechaNac, float sueldo, ArrayList<Hijo> hijos) {
        this.nif = nif;
        this.nom = nom;
        this.cognom = cognom;
        this.fechaNac = fechaNac;
        this.sueldo = sueldo;
        this.hijos = hijos;
    }

    public Empleado(){
        nif = "";
        nom = "";
        cognom = "";
        this.fechaNac = new GregorianCalendar();
        sueldo = 0;

    }

    public ArrayList<Hijo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Hijo> hijos) {
        this.hijos = hijos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public GregorianCalendar getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(GregorianCalendar fechaNac) {
        this.fechaNac = fechaNac;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
}
