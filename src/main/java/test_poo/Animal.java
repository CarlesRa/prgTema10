

package test_poo;

public class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }
    public void makeSound(){
        System.out.println("UUUUUUU");
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                '}';
    }


}

