package exercici05;

import java.util.ArrayList;

public class Consultes{
    private ArrayList <Pacient> pacients;
    public Consultes(){
        pacients = new ArrayList<>();
    }
    public void add(Pacient e){
        pacients.add(e);
    }
    public Pacient get(int position){
        return pacients.get(position);
    }
    public int []menorMajor(){
        int [] menorMajor = new int[2];
        int menor = Integer.MAX_VALUE;
        int major = Integer.MIN_VALUE;
        for (int i = 0; i<pacients.size(); i++){
            if(pacients.get(i).calcularEdat() < menor){
                menor = i;
            }
            else{
                major = i;
            }
        }
        menorMajor[0] = menor;
        menorMajor[1] = major;
        return menorMajor;
    }

    public int [] pacientsPerSexe(){
        int [] pacientsPerSexe = new int[2];
        int contadorMasculi = 0;
        int contadorFemeni = 0;
        for (int i=0; i<pacients.size(); i++){
            if (pacients.get(i).getSexe() == 'M'){
                contadorMasculi++;
            }
            else{
                contadorFemeni++;
            }
        }
        pacientsPerSexe[0] = contadorMasculi;
        pacientsPerSexe[1] = contadorFemeni;
        return pacientsPerSexe;
    }

    public String diagnosticoIMC(float iMC){
        String diagnostico = "";
        if (iMC < 18.5){
            diagnostico = "Pes insuficient";
        }
        else if (iMC == 18.5 && iMC <=24.9){
            diagnostico = "Pes normal";
        }
        else if (iMC == 25 && iMC <=26.9){
            diagnostico = "Sobrepes grau I";
        }
        else if (iMC == 27 && iMC <= 29.9){
            diagnostico = "Sobrepes greu II";
        }
        else{
            diagnostico = "Sobrepes grau III";
        }
        return diagnostico;
    }

}
