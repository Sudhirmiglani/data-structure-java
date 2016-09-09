package com.dp;

/**
 * Created by sudhirmiglani on 21/05/16.
 */
public class MaximumSquareMatrix {

    private static int getMin(int x, int y, int z) {
        if (x < y && x < z) {
            return x;
        } else if (y < x && y < z) {
            return y;
        }
        return z;
    }

    public static void main(String ar[]) {

        int arr[][] = {{1, 1, 0, 1, 1}, {0, 1, 1, 1, 1}, {0, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {0, 1, 1, 1, 0}};

        int temp[][] = new int[arr.length][arr[0].length];

        int max = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[0].length; j++) {

                if (i == 0 || j == 0) {
                    temp[i][j] = arr[i][j];
                    max = temp[i][j] > max ? temp[i][j] : max;
                } else if (arr[i][j] == 0) {
                    temp[i][j] = 0;
                } else {
                    temp[i][j] = getMin(temp[i - 1][j - 1], temp[i - 1][j], temp[i][j - 1]) + 1;
                    max = temp[i][j] > max ? temp[i][j] : max;
                }

            }

        }

        System.out.println(max);
    }

}
