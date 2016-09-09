package com.interviews;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sudhirmiglani on 03/09/16.
 */
public class BlackRock {


    private static String getNext(String s) {
        char arr[] = s.toCharArray();
        int n = arr.length;

        int i, j;

        for (i = n - 1; i > 0; i--)
            if (arr[i] > arr[i - 1])
                break;

        if (i == 0) {
            return "no answer";
        }

        int x = arr[i - 1], smallest = i;
        for (j = i + 1; j < n; j++)
            if (arr[j] > x && arr[j] < arr[smallest])
                smallest = j;

        swap(arr, smallest, i - 1);

        Arrays.sort(arr, i, n);
        return String.valueOf(arr);
    }

    private static void swap(char[] arr, int x, int y) {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String a[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        System.out.println(getNext(line));
    }
}
