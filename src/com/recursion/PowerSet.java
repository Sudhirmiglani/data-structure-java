package com.recursion;

import java.util.ArrayList;

/**
 * Created by sudhirmiglani on 27/07/16.
 */
public class PowerSet {

    private static ArrayList<Integer> convertToSet(int k, ArrayList<Integer> set) {

        ArrayList<Integer> subSets = new ArrayList<>();
        int index = 0;
        for (int i = k; i > 0; i >>= 1) {
            if ((k & 1) == 1) {
                subSets.add(set.get(index));
            }
            index++;
        }
        return subSets;
    }

    private static void generate(ArrayList<Integer> arrayList) {

        int n = 1 << arrayList.size();
        ArrayList<ArrayList<Integer>> masterList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            masterList.add(convertToSet(i, arrayList));
            System.out.println(masterList);
        }


    }

    public static void main(String ar[]) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        generate(arrayList);


    }

}
