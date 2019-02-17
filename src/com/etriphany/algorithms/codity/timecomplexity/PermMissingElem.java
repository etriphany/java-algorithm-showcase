package com.etriphany.algorithms.codity.timecomplexity;

/**
 * Check if a permutation (1..N) has a missing element, and if so which one
 *
 * Examples:
 *      1, 2, 3         (ok)
 *      1, 2            (missing 2)
 *      1, 2, 4, 6, 5   (missing 3)
 */
public class PermMissingElem {

    public static void main(String[] args) {
        PermMissingElem instance = new PermMissingElem();
        System.out.println(instance.solution(new int[]{1, 2, 4, 5, 6, 7, 9, 3}));
    }

    // Time O(N) / Space O(1)
    public int solution(int[] a) {

        // Compute Sum in the Arithmetic Progression 1..N
        // aka Arithmetic Series given by (N * (1 + N)) / 2
        long n = a.length + 1; // range is [1..(N + 1)]
        long sum = (n * (1 + n)) / 2;

        // Now for each element in a, subtract it from sum
        for (int i = 0; i < a.length; ++i) {
            sum = sum - a[i];
        }

        // The missing element in the Arithmetic Progession is here
        return (int) sum;
    }
}
