package com.hackerrank;


import java.io.BufferedReader;
import java.io.InputStreamReader;


class AmazonTest4 {
    private static String isDivisible(int[] number, int length) {
        if (length == 1) {
            if (number[0] == 7) {
                return "YES";
            } else {
                return "NO";
            }
        }
        else {
            return "YES";
        }

    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        String line = br.readLine();
        int Q = Integer.parseInt(line);
        String temp[];
        int i, j;
        String num;
        for (int k = 0; k < Q; k++) {
            line = br.readLine();
            temp = line.split(" ");
            i = Integer.parseInt(temp[0]);
            j = Integer.parseInt(temp[1]);
            int arr[] = new int[j - i + 1];
            num = number.substring(i - 1, j);
            int m = 0;
            for( ; m < (j-i+1); m++){
                arr[m] = Integer.parseInt(String.valueOf(num.charAt(m)));
            }

            System.out.println(isDivisible(arr, m));
        }

    }
}
