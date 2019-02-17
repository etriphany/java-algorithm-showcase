package com.etriphany.algorithms.codity.arrays;

public class CyclicRotation {

    public static void main(String[] args) {
        int[] rotated = new CyclicRotation().solution(new int[] {1,2,3,4,5,6,7}, 2);
        for(int i : rotated) {
            System.out.print(i + " ");
        }
    }

    // Time O(n) Space O(1)
    public int[] solution(int[] array, int rotateBy) {
        int[] rotated = new int[array.length];

        for(int i = 0; i < array.length; ++i) {
            // For right to left
            if (i < rotateBy) {
                // array length must be used as an offset
                rotated[array.length - (rotateBy - i)] = array[i];
            } else {
                rotated[i - rotateBy] = array[i];
            }
        }

        return rotated;
    }
}
