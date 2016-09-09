package com.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by sudhirmiglani on 30/07/16.
 */
public class CrowdFire2 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        double arr1[] = new double[n];
        double arr2[] = new double[n];
        String temp[];
        line = br.readLine();
        temp = line.split(" ");
        for (int i = 0; i < n; i++) {
            arr1[i] = Double.parseDouble(temp[i]);
        }
        line = br.readLine();
        temp = line.split(" ");
        for (int i = 0; i < n; i++) {
            arr2[i] = Double.parseDouble(temp[i]);
        }

        line = br.readLine();
        int fuel = Integer.parseInt(line);

        double max = 0;
        for(int i = 0 ; i < n ; i++){
            double temporary = arr2[i]/arr1[i];
            if(fuel/temporary > max){
                max = fuel/temporary;
            }

        }
        max = 0;
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.FLOOR);
        System.out.println(df.format(max));

    }

}


//6
//        250 240 230 220 210 211
//        5000 4500 4000 3500 3000 3000
//        50000
