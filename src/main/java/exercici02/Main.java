package exercici02;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayListEstadisticas aList = new ArrayListEstadisticas();
        aList.add(5.0);
        aList.add(4.0);
        aList.add(3.0);
        aList.add(4.0);
        aList.add(5.0);
        aList.add(5.0);
        aList.add(5.0);
        aList.add(4.0);
        System.out.println("El valor mínim es: "+aList.minimo());
        System.out.println("El valor màxim es: "+aList.maximo());
        System.out.println("La suma de tots els elements es: "+aList.sumatorio());
        System.out.println("La mitjana de tots els elements es: "+aList.media());
    }
}
