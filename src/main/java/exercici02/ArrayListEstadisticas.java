package exercici02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayListEstadisticas implements Iestadisticas{

    private ArrayList <Double> aList;

    public ArrayListEstadisticas(){
        aList = new ArrayList<>();
    }
    @Override
    public double minimo() {
        double x = Double.MAX_VALUE;
        for (double d : aList){
            if (d < x){
                x = d;
            }
        }
        return Math.round(x*100)/100;
    }

    @Override
    public double maximo() {
        double x = Double.MIN_VALUE;
        for (double d : aList){
            if (d > x){
                x = d;
            }
        }
        return Math.round(x*100)/100;
    }

    @Override
    public double sumatorio() {
        double x = 0;
        for (double z : aList){
            x += z;
        }
        return Math.round(x*100)/100;
    }

    @Override
    public double media() {
        double x = 0;
        for (double d : aList){
            x += d;
        }
        x = x/aList.size();
        return Math.round(x*100)/100;
    }

    @Override
    public double moda() {
        //TODO implementar hashmap.
        double x = 0;
        return x;
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public void add(double o) {
        aList.add(o);
    }

    public void remove(double o) {
        aList.remove(0);
    }

    public double get(int o) {
        aList.get(o);
        return o;
    }
}

