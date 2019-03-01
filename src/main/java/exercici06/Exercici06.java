package exercici06;

import utils.Lib;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercici06 {
    private int eleccioMenu;
    private Traductor traductor;
    private static Scanner lec;
    public Exercici06(){
        traductor = new Traductor();
        lec = new Scanner(System.in);
        do{

            eleccioMenu = mostrarMenu();
            switch (eleccioMenu){
                case 1:{
                    traductor.inserirParelles();
                    break;
                }
                case 2:{
                    traductor.traduirParaules();
                    break;
                }
                case 0:{
                    break;
                }
                default:{

                    System.out.println("Opcio incorrecta");
                    Lib.continuar();
                }
            }
        }while (eleccioMenu!=0);
    }
    public int mostrarMenu(){
        int eleccio = Integer.MAX_VALUE;
        System.out.println("MENU PRINCIPAL");
        System.out.println("==============");
        System.out.println("1. Inserir parelles de paraules: ");
        System.out.println("2. Traduir paraules: ");
        System.out.println("0. Eixir de l'aplicació. ");
        System.out.print("Selecciona una opció: ");
        try {
            eleccio = Integer.parseInt(lec.nextLine());
        }
        catch (InputMismatchException imme){
            System.out.println("opció incorrecta....");
        }
        catch (NumberFormatException nfe){
            System.out.println("opció incorrecta....");
        }
        return  eleccio;
    }
}
