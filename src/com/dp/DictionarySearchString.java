package com.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sudhirmiglani on 03/06/16.
 */
public class DictionarySearchString {

    private static final Set<String> dictionary = new HashSet<>(Arrays.asList("arrays", "dynamic", "heaps", "IDeserve", "learn", "learning", "linked", "list", "platform", "programming", "stacks", "trees"));

    public static boolean hasValidWords(String words) {

        // Empty string
        if (words == null || words.length() == 0) {
            return true;
        }

        int n = words.length();
        int k = 0;
        boolean[] validWords = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (dictionary.contains(words.substring(k, i + 1))) {
                validWords[i] = true;
                k = i + 1;
            }
            if (validWords[i]) {
                for (int j = i + 1; j < n; j++) {
                    if (dictionary.contains(words.substring(i + 1, j + 1))) {
                        validWords[j] = true;
                    }
                }
            }
        }
        return validWords[n - 1];
    }

    public static void main(String[] args) {
        if (hasValidWords("IDeservearrays"))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
