package com.etriphany.algorithms.ds.queue;

import java.lang.reflect.Array;

/**
 * Raw implementation of a Queue (FIFO data structure)
 */
public class Queue<T> {

    private T[] innerArray; // 2, 1, 0 > d(0) -> 2, 1 > d(1) -> 2 > e(9) > 9, 2

    private int eleCount;

    private int capacity;

    public Queue(Class<T> tClass, int capacity) {
        innerArray = (T[])Array.newInstance(tClass, capacity);
        this.capacity = capacity;
    }

    /**
     * Remove element from queue front
     *
     * @return
     */
    public T dequeue() {
        if(eleCount == 0) {
            return null;
        }
        T result = innerArray[0];
        --eleCount;

        T[] temp = (T[])Array.newInstance(innerArray.getClass().getComponentType(), this.capacity);
        System.arraycopy(innerArray, 1, temp, 0, this.capacity-1);
        innerArray = temp;
        return result;
    }

    /**
     * Add element on queue back
     *
     * @param element
     */
    public void enqueue(T element) {
        if(eleCount == capacity) {
            throw new IllegalStateException("Queue is full");
        }

        innerArray[eleCount] = element;
        ++eleCount;
    }

    public static void main(String[] args) {
        Queue myQueue = new Queue(Integer.class, 10);

        for(int i = 0; i < 10; ++i) {
            myQueue.enqueue(i);
        }
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.enqueue(10);

        for(int i = 0; i < 10; ++i) {
            System.out.print(String.format(" %d ", myQueue.dequeue()));
        }


    }
}
