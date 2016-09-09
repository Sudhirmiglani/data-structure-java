package com.array;

/**
 * Created by sudhirmiglani on 11/06/16.
 */
public class Heapify {
// 16 14 10 8 7 9 3 2 4 1

    public static int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
    public static int counter = 0;

    public static void main(String[] args) {
        int i;
        int k = 3;
        int heap[] = new int[k];
        for (i = 0; i < heap.length; i++) {
            heap[i] = arr[i];
        }

        heapify(heap);

//        for (int j = k; j < arr.length; j++) {
//
//        }

        for (i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void heapify(int[] x) {
        int i;
        for (i = (x.length - 1) / 2; i >= 0; i--) {
            heapM(x, i);
        }
    }

    public static void heapM(int[] arr, int i) {

        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (((left < arr.length) && (arr[left] > arr[i]))) {
            largest = left;
        }

        if (((right < arr.length) && (arr[right] > arr[largest]))) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapM(arr, largest);
        }
    }

    private static void swap(int i, int largest) {
        int t = arr[i];
        arr[i] = arr[largest];
        arr[largest] = t;

    }
}