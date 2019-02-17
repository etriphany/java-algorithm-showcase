package com.etriphany.algorithms.codity.timecomplexity;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A Frog jump size is d.
 * It wants to go from point x to point y (y > x).
 * How many jumps it will need to get there?
 */
public class FrogJump {

    public static void main(String[] args) {
        FrogJump instance = new FrogJump();
        System.out.println(instance.solution_A(10, 85, 30));

        System.out.println(instance.solution_A(3, 999111321, 7));
        System.out.println(instance.solution_B(3, 999111321, 7));
        System.out.println(instance.solution_C(3, 999111321, 7));
        System.out.println(instance.wrong_solution(3, 999111321, 7));

    }

    // Time O(1) Space O(1)
    public int solution_A(int x, int y, int d) {
        double full = ((double) y - (double) x) / d; // full steps to go
        double half = full % 1; // half step to go

        int result = (int) full;
        if (half > 0) {
            return ++result;
        }
        return result;
    }

    // Time O(1) Space O(1)
    public int solution_B(int x, int y, int d) {
        double distance = (double) y - (double) x;
        return (int) Math.ceil(distance / d);
    }

    // Time O(1) Space O(1)
    public int solution_C(int x, int y, int d) {
        // Use Java BigDecimal
        return new BigDecimal(y - x)
                .divide(new BigDecimal(d), RoundingMode.CEILING)
                .intValue();
    }

    public int wrong_solution(int x, int y, int d) {
        int distance = y - x; // wrong precision
        return (int) Math.ceil(distance / d);
    }
}
