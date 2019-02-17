package com.etriphany.algorithms.ds.array;

public class ArrayReverse {

    public static void main(String args[]) {
        final int[] original = new int[] {1 ,3 ,5, 7, 9, 44, 66};

        int[] a = new ArrayReverse().computeA(original);
        for(int i : a) {
            System.out.print(i + " ");
        }

        System.out.println("\n---------");

        new ArrayReverse().computeB(original);
        for(int i : original) {
            System.out.print(i + " ");
        }
    }

    public int[] computeA(int[] array) {
        int j = 0;
        int[] reverse = new int[array.length];

        for(int i = array.length - 1; i >= 0; --i) {
            reverse[j] = array[i];
            ++j;
        }

        return reverse;
    }


    public void computeB(int[] array) {
        int size = array.length;
        int middle = array.length  / 2;

        int tempI, tempOp;
        // Iterate until the array middle is reached
        for(int i = 0; i < middle; ++i) {

            // Compute the opposite of i
            int op = size - i - 1;

            // Shift i with its opposite
            tempI = array[i];
            tempOp = array[op];
            array[op] = tempI;
            array[i] = tempOp;
        }

    }
}
