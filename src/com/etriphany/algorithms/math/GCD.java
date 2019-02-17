package com.etriphany.algorithms.math;

/**
 * Greatest Common Divisor of 2 positive numbers
 * Euclid's algorithm version
 */
public class GCD {

    public static void main(String[] args) {
        GCD instance = new GCD();

        System.out.println(instance.compute(10, 5));
        System.out.println(instance.compute(3, 2));
        System.out.println(instance.compute(16, 14));
        System.out.println(instance.compute(54, 24));
    }


    public Integer compute(Integer v1, Integer v2) {
        // Shift values to divide the bigger
        if (v2 > v1) {
            return compute(v2, v1);
        }

        // Avoid division by 0
        if (v2 == 0) {
            return 0;
        }

        // GDC algorithm core
        Integer gdc = v1 % v2;
        if (gdc == 0) {
            // V2 is the gdc of v1, v2
            return v2;
        }
        // Iterate again using v2, gdc
        return compute(v2, gdc);
    }
}
