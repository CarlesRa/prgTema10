
package test_poo;

public class Perro extends Animal {

    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void makeSound(){
        System.out.println("guau guau!!");
    }
}
