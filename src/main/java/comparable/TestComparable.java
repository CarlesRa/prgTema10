package comparable;

import com.github.javafaker.Faker;
import utils.Lib;

import java.util.ArrayList;
import java.util.Collections;

public class TestComparable {
    public static void main(String[] args) {
        Persona person = new Persona();
        ArrayList <Persona> lista = new ArrayList<>();
        Faker faker = new Faker();
        for (int i=+1  ; i<15; i++){
            lista.add(new Persona(faker.name().firstName(),faker.name().lastName(), Lib.random(10,36)));
        }
        System.out.println(lista);
        System.out.println();
        Collections.sort(lista);
        System.out.println(lista);
    }
}
