package exercici05;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dataNaiximent = Calendar.getInstance();
        try {
            dataNaiximent.setTime(sdf.parse(this.dataNaiximent));
        }
        catch (ParseException pe){

        }
        //arreplegue lora actual.
        Calendar fechaActual = Calendar.getInstance();
        // calcule les diferencies
        int anys = fechaActual.get(Calendar.YEAR)-dataNaiximent.get(Calendar.YEAR);
        int mesos = fechaActual.get(Calendar.MONTH)-dataNaiximent.get(Calendar.MONTH);
        int dies = fechaActual.get(Calendar.DAY_OF_MONTH)-dataNaiximent.get(Calendar.DAY_OF_MONTH);
        // filtrem els resultats
       if (dies > 0 && mesos <=0){
           anys--;
       }
       else if (dies >=0 && dies >0){
           anys++;
       }
       return anys;
    }

    public float calcularIMC(){
        float iMC = this.pes/(this.altura * this.altura);
        return iMC;
    }


}


