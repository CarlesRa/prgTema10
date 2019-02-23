package exercici01;

import utils.Lib;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercici01 {
    public Exercici01(){
        int [] vector = new int[10];
        for (int i=0; i<vector.length; i++){
            vector[i] = Lib.random(0,50);
        }
        System.out.println(Arrays.toString(vector));
        System.out.println(vList(vector).toString());
    }

    public ArrayList <Integer> vList(int [] vector){
        int puntero = vector.length-1;
        int punteroP = 0;
        ArrayList <Integer> aList = new ArrayList<Integer>(vector.length);
        for (int z=0; z<vector.length; z++){
            aList.add(z,0);
        }
        for (int i=0; i<vector.length; i++){
            if (vector[i]%2==0){
                aList.set(punteroP,vector[i]);
                punteroP++;
            }
            else{
                aList.set(puntero,vector[i]);
                puntero--;
            }
        }
        return aList;
    }
}
