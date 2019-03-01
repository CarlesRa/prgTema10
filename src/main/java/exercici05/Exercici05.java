package exercici05;

import utils.Lib;

import java.util.ArrayList;

public class Exercici05 {
    private Pacient  pacient;
    private Consultes consulta;

    public Exercici05(){
        consulta = new Consultes();
        consulta.add(pacient = new Pacient(1,"12/02/1980",'F',57.0f,1.63f));
        consulta.add(pacient = new Pacient(2,"07/03/1990",'F',60.5f,1.74f));
        consulta.add(pacient = new Pacient(3,"20/03/1967",'F',50.8f,1.62f));
        consulta.add(pacient = new Pacient(4,"20/04/1972",'M',72.5f,1.78f));
        consulta.add(pacient = new Pacient(5,"29/02/1960",'M',85.2f,1.8f));
        Lib.limpiarPantalla();
        System.out.println("PACIENT MAJOR Edat: " + consulta.get(consulta.menorMajor()[1]).getEdat());
        System.out.println("PACIENT MENOR Edat: " + consulta.get(consulta.menorMajor()[0]).getEdat());
        System.out.println("\nQuantitat de pacients per sexes: ");
        System.out.println("Homes: " + consulta.pacientsPerSexe()[0] + "     Dones: "
        + consulta.pacientsPerSexe()[1]);
        System.out.println();

        for (int i=0; i<consulta.size(); i++){
            System.out.println("Pacient número " + (i+1) + ": "
            + consulta.diagnosticoIMC(consulta.get(i).getIndexMasaCorporal()));
        }
    }
}

