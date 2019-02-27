package exercici04;

import java.util.ArrayList;

public class Cola <T> implements Icola <T> {
    private ArrayList <T> cola;
    public Cola(){
        cola = new ArrayList<>();
    }

    @Override
    public T add(T e) {
        cola.add(e);
    return e;
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
        return cola.get(0);
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
