package com.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sudhirmiglani on 15/06/16.
 */
public class SubStringVowelConsonant {

    public static void main(String[] args) {
        findSubString("ebaeba");
    }

    private static void findSubString(String s) {

        if(s != null) {
            String first = null,last = null;
            Set<Character> vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');

            for(int i =0; i< s.length();i++) {

                if(vowels.contains(s.charAt(i))) {
                    for (int k = i + 1; k < s.length(); k++) {
                        if(!vowels.contains(s.charAt(k))) {

                            String temp = s.substring(i,k + 1);
                            if(first == null && last == null) {
                                first = temp;
                                last = temp;
                            }
                            else {
                                if(first.compareTo(temp) > 1) {
                                    first = temp;
                                }

                                if(last.compareTo(temp) < 1) {
                                    last = temp;
                                }
                            }


                        }
                    }
                }
            }

            System.out.println("First  = " + first);
            System.out.println("Last  = " + last);
        }


    }
}
