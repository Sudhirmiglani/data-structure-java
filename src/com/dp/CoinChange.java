package com.dp;

/**
 * Created by sudhirmiglani on 21/07/16.
 */

import java.util.*;

public class CoinChange {

    private static int countWays(int[] arr, int sum, int index, int[][] lookup) {
         if (sum < 0 || index >= arr.length) {
            return 0;
        } else {
            if( lookup[sum][index] == -1){
                lookup[sum][index] = countWays(arr, sum - arr[index], index, lookup) + countWays(arr, sum, index + 1, lookup);
            }
            return lookup[sum][index];
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        int lookup[][] = new int[n+1][m];
        for (int i = 0; i <= n; i++) {
            for(int j = 0 ;j < m ;j++){
                lookup[i][j] = -1;
            }
        }
        for (int i = 0; i < m; i++) {
            lookup[0][i] = 1;
        }

        System.out.println(countWays(arr, n, 0, lookup));

    }
}