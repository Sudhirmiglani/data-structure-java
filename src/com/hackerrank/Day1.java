package com.hackerrank;

/**
 * Created by sudhirmiglani on 27/06/16.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Day1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();

        boolean isPossible = true;
        if ((x2 > x1 && v2 > v1) || (x2 < x1 && v2 < v1)) {
            isPossible = false;
        } else if (x1 == x2) {
            isPossible = true;
        } else if (v1 == v2) {
            isPossible = false;
        } else {
            if (x1 < x2) {
                while (x1 < x2) {
                    x1 = x1 + v1;
                    x2 = x2 + v2;
                }
            } else {
                while (x1 > x2) {
                    x1 = x1 + v1;
                    x2 = x2 + v2;
                }
            }
            if (x1 != x2) {
                isPossible = false;
            }

        }
        System.out.println(isPossible ? "YES" : "NO");

    }
}

