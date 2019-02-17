package com.etriphany.algorithms.codity.arrays;

class OddOccurrencesInArray {

    public static void main(String[] args) {
        OddOccurrencesInArray instance = new OddOccurrencesInArray();
        System.out.println(instance.solution(new int[] {9, 3, 9, 3, 9, 7, 9})); // 7
        System.out.println(instance.solution(new int[] {4, 1, 33, 12, 1, 12, 33, 8, 4})); // 8
    }

    // Time O(n) Space O(1)
    public int solution(int[] A) {
        // For O(n) we solution the XOR, since just 1 element is even
        // all other odd elements will cancel each other and the
        // final result will be the even value
        int result = A[0];
        for(int i = 1; i < A.length; ++i) {
            result ^= A[i];
        }

        return result;
    }

}