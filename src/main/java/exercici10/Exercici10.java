package exercici10;

import utils.Lib;

import java.util.Scanner;

public class Exercici10 {
    private int eleccio;
    private int eleccio2;
    private Empresa empresa;
    public Scanner lec;
    public Exercici10() {
        empresa = new Empresa();
        lec = new Scanner(System.in);
        do {
            eleccio = menuPrincipal();
            switch (eleccio){
                case 1:{
                    break;
                }
                case 2:{
                    break;
                }
                case 3:{
                    break;
                }
                case 4:{
                    break;
                }
                case 5:{
                    break;
                }
                case 6:{
                    break;
                }
                case 7:{
                    do{
                        eleccio2 = menuConsultas();
                        switch (eleccio2){
                            case 1:{
                                empresa.nuevoEmpleado();
                                break;
                            }
                            case 2:{
                                break;
                            }
                            case 3:{
                                break;
                            }
                            case 4:{
                                break;
                            }
                            case 5:{
                                break;
                            }
                            case 0:{
                                break;
                            }
                            default:{
                                System.out.println("Opcion incorreta...");
                                Lib.continuar();
                                break;
                            }
                        }
                    }while (eleccio2!=0 || eleccio2>5 || eleccio2<0);
                }
                case 0:{
                    break;
                }
                default:{
                    System.out.println("Oppción incorrecta...");
                    Lib.continuar();
                }
            }
        }while (eleccio != 0 || eleccio2>7 || eleccio2<0);
    }

    public int menuPrincipal() {
        int eleccio = Integer.MAX_VALUE;
        System.out.println("*********************");
        System.out.println("* GESTIÓN EMPLEADOS *");
        System.out.println("*********************");
        System.out.println("1. Nuevo empleado");
        System.out.println("2. Nuevo hijo");
        System.out.println("3. Modificar sueldo");
        System.out.println("4. Borrar empleado");
        System.out.println("5. Borrar hijo");
        System.out.println("6. Borrar hijo");
        System.out.println("7. Consultas");
        System.out.println("---------------------");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        try {
            eleccio = Integer.parseInt(lec.nextLine());
        }
        catch (NumberFormatException nfe){

        }
        return eleccio;
    }
    public int menuConsultas(){
        int eleccio = Integer.MAX_VALUE;
        System.out.println("***********************");
        System.out.println("* CONSULTAS EMPLEADOS *");
        System.out.println("***********************");
        System.out.println("1. Buscar por NIF");
        System.out.println("2. Buscar por nombre");
        System.out.println("3. Buscar por rango de edad");
        System.out.println("4. Buscar por rango de sueldo");
        System.out.println("4. Buscar por hijos menores de edad");
        System.out.println("---------------------");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opcion: ");
        try {
            eleccio = Integer.parseInt(lec.nextLine());
        }
        catch (NumberFormatException nfe1){

        }
        return  eleccio;
    }
}