package com.etriphany.algorithms.codity.timecomplexity;

/**
 * Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
 */
public class TapeEquilibrium {

    public static void main(String[] args) {
        TapeEquilibrium instance = new TapeEquilibrium();
        System.out.println(instance.solution(new int[]{ 3, 1, 2, 4, 3 }));
        System.out.println(instance.solution(new int[]{ 3, 1, 8, 4, 3 }));

    }

    // Time O(N) / Space O(N)
    public int solution(int[] a) {
        long sumL = 0;
        long sumR = 0;
        long result = Long.MAX_VALUE;

        // Initialize sums (0 < p < N)
        // it makes solution O(2 * N) = O(N)
        sumL = a[0];
        for (int p = 1; p < a.length; ++p) {
            sumR += a[p];
        }

        // Check abs sum diffs
        for (int p = 1; p < a.length; ++p) {

            long diff = Math.abs(sumL - sumR);
            if (result > diff) {
                result = diff;
            }

            // Change sums
            sumL += a[p];
            sumR -= a[p];
        }

        return (int) result;
    }
}
