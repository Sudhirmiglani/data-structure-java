package com.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by sudhirmiglani on 30/07/16.
 */
public class CrowdFire3 {

    private static int[] offsets = {-1, 0, +1};

    private static boolean neighborExists(int[][] matrix, int i, int j) {
        if ((i >= 0) && (i < matrix.length) && (j >= 0) && (j < matrix[0].length)) {
            if (matrix[i][j] == 1) {
                return true;
            }
        }

        return false;
    }

    private static void doDFS(int[][] matrix, int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        int xOffset, yOffset;
        for (int l = 0; l < offsets.length; l++) {
            xOffset = offsets[l];
            for (int m = 0; m < offsets.length; m++) {
                yOffset = offsets[m];

                if (xOffset == 0 && yOffset == 0) {
                    continue;
                }

                if (neighborExists(matrix, i + xOffset, j + yOffset)) {
                    doDFS(matrix, i + xOffset, j + yOffset, visited);
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        int arr[][] = new int[n][n];
        String temp[];

        for (int i = 0; i < n; i++) {
            line = br.readLine();
            temp = line.split("");

            for (int j = 0; j < n; j++) {
                arr[i][j] = (line.charAt(j) == '1' ? 1 : 0);
            }

        }
        boolean cache[][] = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if ((arr[i][j] == 1) && (!cache[i][j])) {
                    count += 1;
                    doDFS(arr, i, j, cache);
                }
            }
        }
        System.out.println(count);

    }
}
