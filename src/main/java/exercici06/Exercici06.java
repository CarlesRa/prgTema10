package exercici06;

import java.util.Scanner;

public class Exercici06 {
    private int eleccioMenu;
    private Traductor traductor;
    private static Scanner lec;
    public Exercici06(){
        traductor = new Traductor();
        lec = new Scanner(System.in);
        do{
            System.out.println("MENU PRINCIPAL");
            System.out.println("==============");
            System.out.println("1. Inserir parelles de paraules. ");
            System.out.println("2. Traduir paraules. ");
            System.out.println("0. Eixir de l'aplicació. ");
            System.out.print("Selecciona una opció: ");
            eleccioMenu = lec.nextInt();
            lec.nextLine();
            switch (eleccioMenu){
                case 1:{
                    traductor.inserirParelles();
                    break;
                }
                case 2:{
                    traductor.traduirParaules();
                    break;
                }
            }
        }while (eleccioMenu!=0);
    }
    public int mostrarMenu(){
        int eleccio;
        System.out.println("MENU PRINCIPAL");
        System.out.println("==============");
        System.out.println("1. Inserir parelles de paraules: ");
        System.out.println("2. Traduir paraules: ");
        System.out.println("0. Eixir de l'aplicació. ");
        System.out.print("Selecciona una opció: ");
        eleccio = Integer.parseInt(lec.nextLine());
        return  eleccio;
    }
}
