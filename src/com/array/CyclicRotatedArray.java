package com.array;

/**
 * Created by sudhirmiglani on 21/05/16.
 */
public class CyclicRotatedArray {

    public static int search(int[] arr, int start, int end, int num){
        if(start > end){
            return -1;
        }
        int mid = (start + end)/2;
        if(arr[mid] == num) {
            return mid;
        }else if(arr[start] <= arr[mid]){
            if(num > arr[start] && num < arr[mid]){
                return search(arr, start, mid-1, num);
            }else{
                return search(arr, mid+1, end, num);
            }
        }else {
            if(num > arr[mid] && num < arr[end]){
                return search(arr, mid+1, end, num);
            }else{
                return search(arr, start, mid-1, num);
            }
        }
    }

    public static void main(String args[]) {

        int arr[] = {7,8,9,10,11,1,2,3,4,5,6};
        System.out.println(search(arr, 0, arr.length-1, 90));


    }
}
