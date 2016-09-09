package com.dp;

/**
 * Created by sudhirmiglani on 01/08/16.
 */
public class MinimumJumps {

    private static int minJumps(int arr[]) {
        int n = arr.length;
        int jumps[] = new int[n];  // jumps[n-1] will hold the result
        int i, j;

        if (n == 0 || arr[0] == 0) {
            return Integer.MAX_VALUE;
        }

        jumps[0] = 0;

        // Find the minimum number of jumps to reach arr[i]
        // from arr[0], and assign this value to jumps[i]
        for (i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
    }


    public static void main(String ar[]) {
        int arr[] = {1, 3, 6, 1, 0, 9};
        minJumps(arr);
    }
}
