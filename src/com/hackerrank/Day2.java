package com.hackerrank;

/**
 * Created by sudhirmiglani on 30/06/16.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Day2 {

    public static void heapify(int[] x, int size) {
        int i;
        for (i = (size - 1) / 2; i >= 0; i--) {
            heapM(x, i, size);
        }
    }

    public static void heapM(int[] arr, int i, int size) {

        int min = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (((left < size) && (arr[left] < arr[i]))) {
            min = left;
        }

        if (((right < size) && (arr[right] < arr[min]))) {
            min = right;
        }
        if (min != i) {
            swap(arr, i, min);
            heapM(arr, min, size);
        }
    }

    private static void swap(int[] arr, int i, int largest) {
        int t = arr[i];
        arr[i] = arr[largest];
        arr[largest] = t;

    }

    public static int extractMin(int[] arr, int size) {
        int root = arr[0];
        if (size > 1) {
            arr[0] = arr[size - 1];
            size--;
            heapM(arr, 0, size);
        }
        return root;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int l[] = new int[N];
        int luck = 0;

        int size = 0;
        for (int i = 0; i < N; i++) {
            int temp1 = in.nextInt();
            int temp2 = in.nextInt();
            if (temp2 == 0) {
                luck += temp1;
            } else {
                l[size++] = temp1;
            }

        }
        heapify(l, size);

        for (int i = 0; i < size; i++) {
            System.out.print(l[i]);
        }
        System.out.println("====");
        int k = size - K;
        for (int i = 0; i < k; i++) {
            luck = luck - extractMin(l, size);

            size--;
        }

        for (int i = 0; i < size; i++) {
            luck = luck + l[i];
        }

        System.out.println(luck);


    }
}
