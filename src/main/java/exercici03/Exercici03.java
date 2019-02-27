package exercici03;

import utils.Lib;

public class Exercici03 {
    private Pila <Integer> pila;
    public Exercici03(){
        pila = new Pila<Integer>();
        System.out.println(pila.isEmpty());
        for (int i=0; i<40; i++){
            int random = Lib.random(0,50);
            System.out.print(random + "-");
            pila.push(random);
        }
        pila.push(24);
        pila.pop();
        pila.pop();
        pila.pop();
        pila.pop();
        System.out.println("\n"+pila.toString());
        System.out.println(pila.isEmpty());
        System.out.println("la pila conte: " + pila.size() + " elements");
    }
}
