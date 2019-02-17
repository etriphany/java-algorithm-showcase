package com.etriphany.algorithms.codity.timecomplexity;

public class FrogJump {


    public static void main(String[] args) {
        FrogJump instance = new FrogJump();
        System.out.println(instance.solution(10, 85, 30));
        System.out.println(instance.solution(3, 999111321, 7));
    }


    // Time O(1) Space O(1)
    public int solution(int X, int Y, int D) {
        double full = ((double)Y- (double)X) / D; // full steps to go
        double half = full % 1; // half step to go

        int result = (int) full;
        if(half > 0) {
            return ++result;
        }
        return result;

        // OR
        /*
            new BigDecimal(Y - X).divide(new BigDecimal(D), RoundingMode.CEILING).int;
            int distance = Y - X;
            return (int)Math.ceil(distance / D);
        */
    }
}
