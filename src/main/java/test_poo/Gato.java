/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package test_poo;

public class Gato extends Animal{
    private  String color;

    public Gato(String nombre, String color) {
        super(nombre);
        this.color = color;
    }

    @Override
    public void makeSound(){
        System.out.println("Miau Miau!!");
    }
}
