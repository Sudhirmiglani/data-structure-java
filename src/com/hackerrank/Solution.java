package com.hackerrank;

import java.io.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int i = 0;
        boolean isMultiFound = false;
        while ( i < args.length ){
            String str = args[i];
            int index1 = str.indexOf("/*");
            int index2 = str.indexOf("//");
            int index3 = str.indexOf("*/");

            if(isMultiFound){
                System.out.println(str);
                if(index3 > -1){
                    isMultiFound = false;
                }
            }
            else if(index1 > -1 && index1 > index2){
                isMultiFound = true;
                System.out.println(str.substring(index1, str.length()));
            }else if(index2 > -1){
                System.out.println(str.substring(index2, str.length()));
            }
            i++;
        }

    }
}