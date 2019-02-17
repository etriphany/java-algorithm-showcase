package com.etriphany.algorithms.functional;

import java.util.Arrays;

public class Distance {

    public static void main(String[] args) {

        Distance d = new Distance();
        //System.out.println(d.solve("abcccd"));

        System.out.println(d.mostPopulaNumber(new int[] {1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 2, 2}));

    }


    public int mostPopulaNumber(int[] a) {
        Arrays.sort(a);

        int maxCnt = 0;
        int count = 0;
        int res = Integer.MAX_VALUE;

        for(int i = 0; i < a.length - 1; ++i) {

             if(a[i] == a[i + 1]) {
                 ++count;
             } else {
                 if(count > maxCnt){
                     maxCnt = count;
                     res = a[i];
                 }
                 count = 0;
             }

        }

        return res;
    }

    private boolean solve(String s) {
        int distance = 0;
        for(int i = 0; i < s.length() / 2; ++i) {

            int r = s.length() - i;

            if(s.charAt(i) != s.charAt(r - 1)) {
                ++distance;
            }

            if(distance > 1) {
                return false;
            }
        }

        return true;
    }
}
