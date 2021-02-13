package com.etriphany.algorithms.math;

/**
 * Square root implementation based on binary search approximation.
 */
public class SqrtBinaySearch {

    private static final double PRECISION = 10.0 / 100000;

    public static void main (String[] args) {
        SqrtBinaySearch instance = new SqrtBinaySearch();
        instance.solution(10);
        instance.solution(12);
        instance.solution(1);
    }

    // Time O(log N) Space O(1)
    public void solution(int value) {
        // Interval
        double start = 1;
        double end = value * 2;
        double middle = (start + end) / 2;

        // Approximate until reach precision
        while((end - start) >= PRECISION) {
            double sqr_m = middle * middle;
            if(sqr_m > value) {
                // Move middle towards end
                end = middle;
            } else {
                // Move middle towards start
                start = middle;
            }
            middle = (start + end) / 2;
        }

        System.out.println(String.format("%.5f vs %.5f", middle, Math.sqrt(value)));
    }
}
