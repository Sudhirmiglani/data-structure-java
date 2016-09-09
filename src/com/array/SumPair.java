package com.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sudhirmiglani on 09/06/16.
 */
public class SumPair {
    private static final int MAX = 100000;

    static void printpairs(int numbers[], int sum) {
        if (numbers.length < 2) {
            return;
        }
        Set set = new HashSet(numbers.length);
        for (int value : numbers) {
            int target = sum - value;
            if (!set.contains(target)) {
                set.add(value);
            } else {
                System.out.printf("(%d, %d) %n", value, target);
            }
        }

    }

    static void totalPairs(int numbers[], int sum) {
        if (numbers.length < 2) {
            return;
        }
        Set set = new HashSet(numbers.length);
        for (int value : numbers) {
            int target = sum - value;
            if (!set.contains(target)) {
                set.add(value);
            } else {
                System.out.printf("(%d, %d) %n", value, target);
            }
        }

    }

    // Main to test the above function

    public static void main(String[] args) {
        int A[] = {-1, 4, 45, 9, 10, 8};
        int n = 7;
        //printpairs(A, n);

        int B[] = {0, 4, 4, 4, 5, 6, 7, 8, 8, 8};
        int sum = 8;
        totalPairs(B, sum);
    }
}
