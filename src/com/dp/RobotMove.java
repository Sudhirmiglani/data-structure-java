package com.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by sudhirmiglani on 13/08/16.
 */


class KeyValuePair implements Comparable<KeyValuePair>{
    int key;
    String value;

    public KeyValuePair(int key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    public int compareTo(KeyValuePair o) {
        return key==o.key?value.compareTo(o.value):o.key-key;
    }
}
public class RobotMove {



    public static void main(String ar[]) throws Exception {



        HashMap<Character,Integer> hashMap = new HashMap<>();
        hashMap.put('a', 2);
        hashMap.put('b', 2);
        hashMap.put('c', 2);
        hashMap.put('d', 3);
        hashMap.put('e', 3);
        hashMap.put('f', 3);
        hashMap.put('g', 4);
        hashMap.put('h', 4);
        hashMap.put('i', 4);
        hashMap.put('j', 5);
        hashMap.put('k', 5);

        hashMap.put('l', 5);
        hashMap.put('m', 6);
        hashMap.put('n', 6);
        hashMap.put('o', 6);
        hashMap.put('p', 7);

        hashMap.put('q', 7);
        hashMap.put('r', 7);
        hashMap.put('s', 7);
        hashMap.put('t', 8);
        hashMap.put('u', 8);

        hashMap.put('v', 8);
        hashMap.put('w', 9);
        hashMap.put('x', 9);
        hashMap.put('y', 9);
        hashMap.put('z', 9);

        SortedSet<KeyValuePair> sortedSet = new TreeSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        for (int i =0 ; i <n ; i++){
            line = br.readLine();
            int value = 0;
            for(int j =0 ; j < line.length(); j++){
                value = value*10 + hashMap.get(line.charAt(j));
            }
            sortedSet.add(new KeyValuePair(value, line));
        }

        for (KeyValuePair keyValuePair : sortedSet) {
            System.out.println(keyValuePair.key+" "+keyValuePair.value);
        }

    }
}
