package com.hackerrank;

/**
 * Created by sudhirmiglani on 30/07/16.
 */
/* IMPORTANT: Multiple classes and nested static classes are supported */


import java.io.BufferedReader;
import java.io.InputStreamReader;


class AmazonTest3 {

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
    private static int getLCM(int[] arr) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            res = res*arr[i]/gcd(res, arr[i]);
        }
        return res;
    }
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int t = Integer.parseInt(line);
        int N,X,Y,Z;
        String temp[];
        int arr[];
        for (int i = 0; i < t; i++) {
            line = br.readLine();
            temp = line.split(" ");
            N = Integer.parseInt(temp[0]);
            X = Integer.parseInt(temp[1]);
            Y = Integer.parseInt(temp[2]);
            Z = Integer.parseInt(temp[3]);
            line = br.readLine();
            temp = line.split(" ");
            arr = new int[N];
            for(int j = 0 ;j < N; j++){
                arr[j] = Integer.parseInt(temp[j]);
            }
            int lcm = getLCM(arr);
            int prod = X*Y*Z;
            while(lcm > 1){
                if(lcm % X == 0){
                    lcm = lcm /X;
                }
                else if(lcm % Y == 0){
                    lcm = lcm / Y;
                }
                else if(lcm % Z == 0){
                    lcm = lcm / Z;
                }
                else{
                    break;
                }
            }
            if(lcm > 1){
                System.out.println("She can\'t");
            }else{
                System.out.println("She can");
            }
        }

    }
}

