package com.array;

/**
 * Created by sudhirmiglani on 04/08/16.
 */
public class ValueAtNEqualToN {


    public static void main(String ar[]) {
        int[] arr = {2, 3, 4, 1, 0};
        int size = arr.length;
        int newValue = 0;
        for (int i = 0; i < size; i++) {
            newValue = arr[arr[i]] % size;
            arr[i] = arr[i] + newValue * size;
        }
        for (int i = 0; i < size - 1; i++)
            arr[i] /= size;

    }
}
