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
        HashMap<Double, Integer> map = new HashMap<>();
        int aux = Integer.MIN_VALUE;
        Double x = 0.0;
        for (double d : aList) {
            Integer count = map.get(d);
            map.put(d, (count == null) ? 1 : count + 1);
            try{
                if (count > aux) {
                    aux = count;
                    if (map.containsValue(aux) == true) {
                        x = d;
                    }
                }
            }
            catch (NullPointerException npe){

            }
        }
        System.out.println(map);
        return Math.round(x * 100) / 100;
    }




    public void add(double o) {
        aList.add(o);
    }


}

