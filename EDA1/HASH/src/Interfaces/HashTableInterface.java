package Interfaces;

public interface HashTableInterface<T extends Comparable<? super T>> {
    public int size();
    public float loadCapacity();
    public abstract int procPos(T s);
    public void allocateTable(int dim);
    public void makeEmpty();
    public T search( T x);
    public void remove(T x);
    public void insert(T x);
    public void rehash();
    public void print();
}
