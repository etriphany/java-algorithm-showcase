package com.etriphany.algorithms.ds.stack;

import java.lang.reflect.Array;

/**
 * Raw implementation of a Stack (FILO data structure)
 */
public class Stack<T> {

    private T[] innerArray;

    private int topIdx;

    public Stack(Class<T> tClass, int capacity) {
        this.innerArray = (T[])Array.newInstance(tClass, capacity);
    }

    /**
     * Add element on stack top
     *
     * @param element
     */
    public void push(final T element) {
        if(topIdx == innerArray.length) {
            throw new IllegalStateException("Stack is full");
        }
        innerArray[topIdx] = element;
        ++topIdx;
    }

    /**
     * Remove element from stack top
     *
     * @return
     */
    public T pop() {
        // Empty stack
        if(topIdx == 0) {
            return null;
        }

        T result = innerArray[topIdx - 1];
        innerArray[topIdx - 1] = null;
        --topIdx;
        return result;
    }

    public static void main(String[] args) {
        Stack myStack = new Stack<Integer>(Integer.class, 10);

        for(int i = 0; i < 10; ++i){
            myStack.push(i);
        }
        myStack.pop();
        myStack.pop();
        myStack.push(10);

        for(int i = 0; i < 10; ++i){
            System.out.print(String.format(" %d ", myStack.pop()));
        }
    }
}

