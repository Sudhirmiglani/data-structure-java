package com.recursion;

import java.util.HashSet;

/**
 * Created by sudhirmiglani on 23/07/16.
 */
public class PermutationOfString {

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);
        }
        for (int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }


    public static HashSet<String> getAllPermutations(String str) {
        // Create a hash set to prevent any duplicate entries
        HashSet<String> permutations = new HashSet<String>();

        if(str == null || str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remainingString = str.substring(1);
        HashSet<String> words = getAllPermutations(remainingString);
        for(String word: words) {
            for(int i = 0; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i);
                permutations.add(prefix + first + suffix);
            }
        }
        return permutations;
    }



    public static void main(String ar[]) {
        //permutation("", "abca");
        getAllPermutations("abca");
    }
}
