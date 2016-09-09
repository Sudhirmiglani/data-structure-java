package com.array;

/**
 * Created by sudhirmiglani on 19/07/16.
 */
public class TappingRainWater {

    private static int getWater(int[] arr){

        if(arr.length <= 2 ){
            return 0;
        }

        int end = arr.length - 1;
        int max1= arr[0], max2 = arr[end];
        for(int i = 1 ; i < end ; i++){

        }


        return 0;
    }


    public static void main(String ar[]){
        int[] arr = {1,2,3,1,3};
        System.out.println(getWater(arr));
    }
}
