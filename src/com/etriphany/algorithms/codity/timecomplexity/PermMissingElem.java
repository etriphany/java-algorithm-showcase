package com.etriphany.algorithms.codity.timecomplexity;

public class PermMissingElem {

    public static void main(String[] args) {
        PermMissingElem instance = new PermMissingElem();
        System.out.println(instance.solution(new int[] {1, 2, 4, 5, 6, 7, 9, 3}));
    }

    // Time O(N) / Space O(1)
    public int solution(int[] A) {

        // Compute Sum in the Arithmetic Progression 1..N
        // aka Arithmetic Series given by (N * (1 + N)) / 2
        long n = A.length + 1; // range is [1..(N + 1)]
        long sum = (n * (1 + n)) / 2;

        // Now for each element in A, subtract it from sum
        for(int i = 0; i < A.length; ++i) {
            sum = sum - A[i];
        }

        // The missing element in the Arithmetic Progession is here
        return (int)sum;
    }
}
