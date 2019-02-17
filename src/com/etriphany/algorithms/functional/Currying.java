package com.etriphany.algorithms.functional;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

import static java.lang.System.out;

public class Currying {

    private static int ACC;

    public static void main(String[] args) {
        // Curried add function returns a function

        IntFunction<IntUnaryOperator> curriedAdd = a -> b -> {
            if(ACC == 0)
                ACC = a + b;
            else
                ACC += b;
            return ACC;
        };

        IntUnaryOperator adder = curriedAdd.apply(1);
        out.println(adder.applyAsInt(2));
        out.println(adder.applyAsInt(3));
        out.println(adder.applyAsInt(4));
    }
}