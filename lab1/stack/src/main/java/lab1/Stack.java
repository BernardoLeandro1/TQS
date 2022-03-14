package lab1;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack<T> {
    private ArrayList<T> stack;
    private int maxStackSize;

    public Stack(){
        this.stack = new ArrayList<T>();
        this.maxStackSize = -1;
    }

    public Stack(int maxSize){
        if (maxSize < 1) {
            throw new IllegalArgumentException("ERROR! The stack maximum size must be > 0!");
        }
        this.stack = new ArrayList<T>();
        this.maxStackSize = maxSize;
    }

    public void push(T s){
        if (this.maxStackSize > 0) {
            if (this.stack.size() < maxStackSize) {
                this.stack.add(s);
            } else {
                throw new IllegalStateException("ERROR!");
            }
        } else {
            this.stack.add(s);
        }
    }

    public T pop(){
        if (this.stack.size() == 0) {
            throw new NoSuchElementException("ERROR! There is nothing to remove!");
        } else {
            return this.stack.remove(this.stack.size() - 1);
        }
    }

    public T peek(){
        if (this.stack.size() == 0) {
            throw new NoSuchElementException("ERROR! There are no elements in this stack!");
        } else {
            return this.stack.get(this.stack.size() - 1);
        }
    }

    public int size(){
        return this.stack.size();
    }

    public boolean isEmpty(){
        return this.stack.size() == 0;
    }

    public void clear(){
        this.stack.clear();
    }

}
