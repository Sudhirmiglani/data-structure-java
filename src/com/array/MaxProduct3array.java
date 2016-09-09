package com.array;

/**
 * Created by sudhirmiglani on 29/07/16.
 */
public class MaxProduct3array {

    private static void maxProduct(int[] arr) {

        int m1 = Integer.MIN_VALUE, m2 = Integer.MIN_VALUE, m3 = Integer.MIN_VALUE, n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            if (element > m1) {
                m1 = element;
            } else if (element > m2) {
                m2 = element;
            } else if (element > m3) {
                m3 = element;
            }

            if (element < n1) {
                n1 = element;
            } else if (element < n2) {
                n2 = element;
            }
        }

        int max1 = m1 * m2 * m3;
        int max2 = m1 * n1 * n2;
//        System.out.println(m1);
//        System.out.println(m2);
//        System.out.println(m3);
        System.out.println(max1 > max2 ? max1 : max2);

    }

    public static void main(String ar[]) {
        int arr[] = {10, 9, 8, -4, 5};

        maxProduct(arr);

    }
}
