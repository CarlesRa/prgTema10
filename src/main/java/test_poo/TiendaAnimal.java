
package test_poo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TiendaAnimal {
    public static void main (String[] args) {
        ArrayList<Animal> list = new ArrayList<>();
        Animal gato = new Gato("Evaristo","Turquesa");
        Animal perro = new Perro("toby");
        Animal paloma = new Paloma("PTOLA");

        list.add(gato);
        list.add(perro);
        list.add(paloma);
        list.add(gato);
        list.add(paloma);
        list.add(perro);
        list.add(gato);

        for (int i=0; i<list.size(); i++){
            list.get(i).makeSound();
        }

        System.out.println(list);
        System.out.println(list);
    }

}
