package exercici03;

public interface Ipila <T>{

    T push(T e);
    T pop();
    int size();
    T top();
    boolean isEmpty();

}
