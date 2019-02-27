package exercici03;

import java.util.ArrayList;

public class Pila <T> implements Ipila<T> {
    private  ArrayList<T> aList;

    public Pila(){
        aList = new ArrayList<T>();
    }

    @Override
    public T push(T e) {
        aList.add(e);
        return e;
    }

    @Override
    public T pop() {

        return aList.remove(aList.size()-1);
    }

    @Override
    public int size() {
        return aList.size();
    }

    @Override
    public T top() {
        return aList.get(aList.size()-1);
    }

    @Override
    public boolean isEmpty() {
        return aList.isEmpty();
    }

    @Override
    public String toString() {
        return "Pila{" +
                "aList=" + aList +
                '}';
    }
}
