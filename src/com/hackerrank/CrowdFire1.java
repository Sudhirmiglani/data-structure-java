package com.hackerrank;

/**
 * Created by sudhirmiglani on 30/07/16.
 */
/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;


class CrowdFire {
    private static int sum4(int n) {
        int ways = 0;
        int l = 0, r;
        for (int i = 1; i < n - 2; i++) {
            for (int j = i; j < n - 1; j++) {
                l = j;
                r = n;

                while (l <= r) {
                    if ((i + j + l + r) == n) {
                        System.out.println(i + ", " + j + ", " + l + ", " + r);
                        ways++;
                        l++;
                        r--;

                    } else if ((i + j + l + r) < n) {

                        l++;
                    } else {

                        r--;
                    }
                }
            }
        }
        return ways;

    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int t = Integer.parseInt(line);
        int n = 0;
        for (int i = 0; i < t; i++) {
            line = br.readLine();
            n = Integer.parseInt(line);
            System.out.println(sum4(n));
        }


    }
}
