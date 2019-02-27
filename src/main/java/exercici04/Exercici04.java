package exercici04;

import utils.Lib;

public class Exercici04 {
    private Cola <Integer> cola;
    public Exercici04(){
        cola = new Cola <Integer>();
        System.out.println("isEmpty: " + cola.isEmpty());
        System.out.println(cola.toString());
        System.out.println("Intento remover un elemento...");
        cola.remove();
        for (int i=0; i<20; i++){
            cola.add(i+1);
        }
        System.out.println("añado 20 elementos");
        System.out.println(cola.toString());
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        System.out.println("remuevo 4 elementos");
        System.out.println(cola.toString());
        System.out.println("peek: " + cola.peek());
        cola.remove();
        System.out.println("Lo remuevo");
        System.out.println(cola.toString());
        System.out.println("size: " + cola.size());
        cola.add(36);
        cola.add(37);
        cola.add(38);
        cola.add(39);
        System.out.println("añado 4 elementos");
        System.out.println(cola.toString());
        System.out.println("remuevo 24 elementos");
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        cola.remove();
        System.out.println(cola.toString());
        for (int i=0; i<10; i++){
            cola.add(i+1);
        }
        System.out.println("añado 10 elementos");
        System.out.println(cola.toString());
        for (int i=0; i<10; i++){
            cola.add(i+1);
        }
        System.out.println("añado 10 elementos");
        System.out.println(cola.toString());
    }
}
