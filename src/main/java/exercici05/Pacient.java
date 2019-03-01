package exercici05;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pacient {
    private int id;
    private String nom;
    private String dataNaiximent;
    private int edat;
    private char sexe;
    private float altura;
    private float pes;
    private Float indexMasaCorporal;
    //constructor
    public Pacient(int id,  String dataNaiximent,char sexe,  float pes, float altura) {
        this.id = id;
        this.nom = nom;
        this.dataNaiximent = dataNaiximent;
        this.sexe = sexe;
        this.altura = altura;
        this.pes = pes;
        this.edat = calcularEdat();
        this.indexMasaCorporal = calcularIMC();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }

    public Float getIndexMasaCorporal() {
        return indexMasaCorporal;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDataNaiximent() {
        return dataNaiximent;
    }

    public void setDataNaiximent(String dataNaiximent) {
        this.dataNaiximent = dataNaiximent;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPes() {
        return pes;
    }

    public void setPes(float pes) {
        this.pes = pes;
    }

    public float calcularIMC(float pes, float altura){

        float iMC = pes/(altura*altura);
        return iMC;
    }

    public  int calcularEdat(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(dataNaiximent, fmt);
        LocalDate ara = LocalDate.now();
        Period periodo = Period.between(fechaNac, ara);
        return periodo.getYears();
    }

    public float calcularIMC(){
        float iMC = this.pes/(this.altura * this.altura);
        return iMC;
    }


}


