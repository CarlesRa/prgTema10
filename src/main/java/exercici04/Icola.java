package exercici04;

public interface Icola <T> {
    boolean add(T e);
    T remove();
    int size();
    T peek();
    boolean isEmpty();
}
