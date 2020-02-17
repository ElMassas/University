package Interfaces;

public interface Stack<E> {
    public E top();
    public E pop() throws RuntimeException;
    public void push(E element) throws StackOverflowError;
    public void empty();
    public int size();
    public E elementAt(int i);
}
