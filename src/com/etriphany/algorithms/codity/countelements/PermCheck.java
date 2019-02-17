package com.etriphany.algorithms.codity.countelements;

import java.util.Arrays;

/**
 * Check if an array is composed by a number sequence (1..N) order not matters
 *
 * Examples:
 *      1, 2, 5, 4, 6, 3    (ok)
 *      1, 2, 5, 2, 4, 3    (nok: repeats 2)
 *      1, 2, 4             (nok: missing 3)
 *
 */
public class PermCheck {

    public static void main(String[] args) {
        PermCheck instance = new PermCheck();
        System.out.println(instance.solution(new int[]{1}));
        System.out.println(instance.solution(new int[]{2}));
        System.out.println(instance.solution(new int[]{1,3,4,2}));
        System.out.println(instance.solution(new int[]{1,3,4}));
    }

    public int solution(int[] a) {
        // Sort array first
        Arrays.sort(a);

        // Special cases
        if(a.length == 1) {
            return (a[0] == 1) ? 1 : 0;
        } else if (a[0] != 1) {
            // First item must be 1
            return 0;
        }

        for(int i = 0; i < a.length - 1; ++i) {
            if(a[i] != a[i+1] - 1)
                return 0;
        }

        // Is permutation
        return 1;
    }
}
