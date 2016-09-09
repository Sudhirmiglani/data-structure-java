package com.strings;

import java.util.*;

/**
 * Created by sudhirmiglani on 15/06/16.
 */
public class MaxCountString {

    public static String getWinner(String[] arr) {

        TreeMap<String, Integer> treeMap = new TreeMap<>();

        String str;
        int val;
        for (int i = 0; i < arr.length; i++) {
            str = arr[i];
            val = 1;
            if (treeMap.containsKey(str)) {
                val = treeMap.get(str);
                val++;
            }
            treeMap.put(str, val);
        }

        System.out.print(treeMap);
        int max = 0;
        String winner = arr[0];
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            int value = entry.getValue();
            if (value >= max) {
                max = value;
                winner = entry.getKey();
            }
        }
        return winner;
    }

    public static void main(String args[]) {
        String[] x = {"Mi", "B", "Mi", "B", "Mi", "B"};
        System.out.println(getWinner(x));
    }

//    static String electionWinner(String[] names) {
//        Map<String, Integer> charFreq = new HashMap<>();
//        if (names != null) {
//            for (String c : names) {
//                Integer count = charFreq.get(c);
//                int newCount = (count == null ? 1 : count + 1);
//                charFreq.put(c, newCount);
//            }
//        }
//        Map<String, Integer> sorted = new TreeMap<>(charFreq);
//        Set<String> mappings =sorted.keySet();
//        String winner = null;
//        int max = 0;
//        for (String mapping : mappings) {
//            if (max <= sorted.get(mapping)) {
//                max = sorted.get(mapping);
//                winner = mapping;
//
//            }
//        }
//        return winner;
//
//    }


}
