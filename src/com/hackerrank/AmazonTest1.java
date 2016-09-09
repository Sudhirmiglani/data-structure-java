package com.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Created by sudhirmiglani on 10/07/16.
 */
public class AmazonTest1 {

    private static int search(int[] arr, long[] cache, int element) {

        int start = 0, end = cache.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (element == cache[mid]) {
                return mid;
            }
            if (start == end) {
                return mid;
            } else if (mid < end && element > cache[mid] && element < cache[mid + 1]) {
                return mid + 1;
            } else if (mid > start && element < cache[mid] && element > cache[mid - 1]) {
                return mid;
            } else if (element > cache[mid]) {
                start = mid + 1;
            } else if (element < cache[mid]) {
                end = mid;
            }
        }

        return 0;
    }


    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int arr[] = new int[N];
        line = br.readLine();
        String temp[] = line.split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        long cache[] = new long[N];
        cache[0] = arr[0];

        for (int i = 1; i < N; i++) {
            cache[i] = cache[i - 1] + arr[i];
        }

        line = br.readLine();
        int Q = Integer.parseInt(line);
        for (int i = 0; i < Q; i++) {
            System.out.println(search(arr, cache, Integer.parseInt(br.readLine())) + 1);
        }


    }
}
