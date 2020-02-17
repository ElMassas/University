import Interfaces.Stack;

public class ArrayStack<E> implements Stack<E>{

    private E[] STACK;
    private int currentIndex = 0;
    private int maxcurrentIndex = 20;

    public ArrayStack(){
        this.STACK = (E[]) new Object[20];
    }

    public ArrayStack(int n){
        this.STACK = (E[]) new Object[n];
        this.maxcurrentIndex = n;
    }

    //If the STACK is empty it should return a NULL value
    @Override
    public E top() {
        return this.STACK[currentIndex];
    }

    //There's no need for a try block here because the stack can be empty, and if so, it should return a NULL value
    @Override
    public void push(E element) {
        if(currentIndex == maxcurrentIndex)throw new StackOverflowError("Stack overflow");
        this.currentIndex +=1;
        this.STACK[currentIndex] = element;
    }

    //The exception prevents the need for another condition
    @Override
    public E pop() {
        if(currentIndex == 0) throw new RuntimeException("Stack Underflow");
        E element = this.STACK[currentIndex];
        this.STACK[currentIndex] = null;
        this.currentIndex -= 1;
        return element;
    }



    @Override
    public void empty() {
        currentIndex = 0;
    }

    @Override
    public int size() {
        return currentIndex;
    }

    @Override
    public E elementAt(int i) {
        return STACK[i];
    }
}
