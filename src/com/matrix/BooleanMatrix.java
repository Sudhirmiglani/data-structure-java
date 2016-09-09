package com.matrix;

/**
 * Created by sudhirmiglani on 01/08/16.
 */
public class BooleanMatrix {

    private static void matrix(int[][] arr, int m, int n, int l, int k) {
        boolean rowFlag = false, colFlag = false;

        for (int i = 0; i < n; i++) {
            if (arr[l][i] == 1) {
                rowFlag = true;
                break;
            }
        }
        //l++;

        for (int i = 0; i < m; i++) {
            if (arr[i][k] == 1) {
                colFlag = true;
                break;
            }
        }
        //k++;

//        for (int i = 0; i < n; i++) {
//            if (arr[l][i] == 1) {
//                rowFlag = true;
//                break;
//            }
//        }
//        l++;
//
//        for (int i = 0; i < m; i++) {
//            if (arr[i][k] == 1) {
//                colFlag = true;
//                break;
//            }
//        }
//        k++;


    }

    public static void main(String ar[]) {

        int arr[][] = {{0, 0, 0, 1}, {0, 0, 0, 0}, {1, 1, 0, 0}};


        int m = arr.length, n = arr[0].length;

        matrix(arr, m, n, 0, 0);

    }
}
