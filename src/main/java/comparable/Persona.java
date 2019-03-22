package comparable;

public class Persona implements Comparable<Persona>{
    static int niax;
    private  int nia;
    private  String nom;
    private String cognom;
    private int edat;

    public Persona(String nom, String cognom, int edat) {
        this.nia = niax + 1;
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
        niax ++;
    }

    public Persona(){
        nia = 0;
        nom = "";
        cognom = "";
        edat = 0;
    }

    public int getNia() {
        return nia;
    }

    public void setNia(int nia) {
        this.nia = nia;
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

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    @Override
    public int compareTo(Persona persona) {
        return this.edat - persona.getEdat();
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nia=" + nia +
                ", nom='" + nom + '\'' +
                ", cognom='" + cognom + '\'' +
                ", edat=" + edat +
                '}' + "\n";
    }
}
