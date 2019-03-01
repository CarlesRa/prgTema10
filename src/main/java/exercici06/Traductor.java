package exercici06;

import utils.Lib;

import java.util.HashMap;
import java.util.Scanner;

public class Traductor {
    private HashMap<String,String> traductor;
    private static Scanner lec = new Scanner(System.in);
    private String paraulaAngles;
    private String paraulaVal;
    private boolean esNumero;
    public void inserirParelles() {
        traductor = new HashMap<>();
        esNumero = false;
        int numeroParelles = 0;
        do{
            System.out.print("Moltes parelles vols introduir: ");
        try {
            numeroParelles = Integer.parseInt(lec.nextLine());
            esNumero = true;
        } catch (NumberFormatException nfe) {
            System.out.println("nomes s'axepten números...");
            esNumero = false;
        }
        }while(!esNumero);
        for (int i=0; i<numeroParelles; i++){
            System.out.print("Inserta paraula en angles: ");
            paraulaAngles = lec.nextLine();
            System.out.print("Inserta paraula en valencia: ");
            paraulaVal = lec.nextLine();
            traductor.put(paraulaAngles,paraulaVal);
        }
    }

    public void traduirParaules(){
        String paraula;
        System.out.print("Inserta paraula a buscar: ");
        paraula = lec.nextLine();
        System.out.println(traductor.get(paraula));
        Lib.continuar();
    }
}
