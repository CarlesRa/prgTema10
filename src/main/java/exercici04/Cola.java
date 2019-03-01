package exercici04;

import java.util.ArrayList;

public class Cola <T> implements Icola <T> {
    private ArrayList <T> cola;
    public Cola(){
        cola = new ArrayList<>();
    }

    @Override
    public boolean add(T e) {
        boolean s;
        s=cola.add(e);
    return s;
    }

    @Override
    public T remove() {
        T removed = (T) new Object();
        try {
            removed = cola.remove(0);
        }
        catch (IndexOutOfBoundsException iobe){
            System.out.println("Remove no valido, No Hay elementos en la cola");
        }
        return removed;
    }

    @Override
    public int size() {
        return cola.size();
    }

    @Override
    public T peek() {
        T peek = (T) new Object();
        try{
            peek = cola.get(0);
        }
        catch(IndexOutOfBoundsException iobe1){
            System.out.println("Peek no valido, No Hay elementos en la cola");
        }
        return peek;
    }

    @Override
    public boolean isEmpty() {
        return cola.isEmpty();
    }

    @Override
    public String toString() {
        return "Cola{" +
                "cola=" + cola +
                '}';
    }
}
