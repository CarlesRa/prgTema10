/*
 * Developed by Carles Ramos
 */

package exercici10;

public class Hijo {
    private String nom;
    private int edad;

    public Hijo(String nom, int edad) {
        this.nom = nom;
        this.edad = edad;
    }
    public Hijo(){
        nom = "";
        edad = 0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
