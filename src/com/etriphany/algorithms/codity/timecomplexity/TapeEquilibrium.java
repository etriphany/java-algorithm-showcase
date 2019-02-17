package com.etriphany.algorithms.codity.timecomplexity;


public class TapeEquilibrium {

    public static void main(String[] args) {
        TapeEquilibrium instance = new TapeEquilibrium();
        System.out.println(instance.solution(new int[]{ 3, 1, 2, 4, 3 }));
        System.out.println(instance.solution(new int[]{ 3, 1, 8, 4, 3 }));

    }

    // Time O(N) / Space O(N)
    public int solution(int[] A) {
        long sumL = 0;
        long sumR = 0;
        long result = Long.MAX_VALUE;

        // Initialize sums (0 < p < N)
        // it makes solution O(2 * N) = O(N)
        sumL = A[0];
        for (int p = 1; p < A.length; ++p) {
            sumR += A[p];
        }

        // Check abs sum diffs
        for (int p = 1; p < A.length; ++p) {

            long diff = Math.abs(sumL - sumR);
            if (result > diff) {
                result = diff;
            }

            // Change sums
            sumL += A[p];
            sumR -= A[p];
        }

        return (int) result;
    }
}
