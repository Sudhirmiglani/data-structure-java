package com.binarySearch;

/**
 * Created by sudhirmiglani on 22/05/16.
 */
public class CubeRoot {

    static int qroot(int x) {
        int a=0,b=x,r;
        for (;;) {
            r = (b + a) / 2;
            int t = r*r*r;
            if (a==b) return r;
            if (t<x) a -= (b-a)/4;
            else b += (b-a)/4;
        }
    }

    public static void main(String args[]){
        System.out.println(qroot(9));
    }
}
