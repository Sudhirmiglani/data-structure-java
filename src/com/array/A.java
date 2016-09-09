package com.array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class A {
    private static String formatWord(String s) {
        s = s.replaceAll(",", "");
        s = s.replaceAll("\\.", "");
        s = s.toLowerCase();
        return s;
    }

    static <K, V extends Comparable<? super V>>
    SortedSet<Map.Entry<Integer, Integer>> entriesSortedByValues(Map<Integer, Integer> map) {
        SortedSet<Map.Entry<Integer, Integer>> sortedEntries = new TreeSet<Map.Entry<Integer, Integer>>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                        if (e1.getValue() < e2.getValue()) {
                            return 1;
                        }
                        return -1;

                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }


    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String words[] = sc.readLine().split(" ");
        Set set = new HashSet(words.length);
        for (String word : words) {
            set.add(formatWord(word));
        }
        int m = Integer.parseInt(sc.readLine());
        int id;
        String review;
        String arr[];
        Map<HotelInfo, Integer> treeMap = new TreeMap<>(new Comparator<HotelInfo>() {
            @Override
            public int compare(HotelInfo o1, HotelInfo o2) {
                if(o1.count == o2.count) {
                    return -1;
                }
                else if(o1.count < o2.count) {
                    return 1;
                }
                return -1;
            }
        });
        for (int i = 0; i < m; i++) {
            id = Integer.parseInt(sc.readLine());
            review = sc.readLine();
            arr = review.split(" ");
            int count = 0;
            for (String w : arr) {
                if (set.contains(formatWord(w))) {
                    count++;
                }
            }
            HotelInfo info = new HotelInfo();
            info.hotelId = id;
            if (treeMap.containsKey(info)) {

                int co = treeMap.get(info);
                info.count = co;
                info.count += count;
                treeMap.put(info, info.count);
            } else {
                info.count = count;
                info.hotelId = id;
                treeMap.put(info, count);
            }
        }

//        SortedSet<Map.Entry<Integer, Integer>> sortedEntries = entriesSortedByValues(treeMap);
        for (Map.Entry<HotelInfo, Integer> sor : treeMap.entrySet()) {
            System.out.print(sor.getKey().hotelId + " ");
        }

    }

    static class HotelInfo {

        private int hotelId;

        private int count;

        @Override
        public int hashCode() {
            return hotelId;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == this) {
                return true;
            }

            if(obj instanceof HotelInfo) {
                return this.hotelId == ((HotelInfo) obj).hotelId;
            }
            return false;
        }

        public int getHotelId() {
            return hotelId;
        }

        public void setHotelId(int hotelId) {
            this.hotelId = hotelId;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

}