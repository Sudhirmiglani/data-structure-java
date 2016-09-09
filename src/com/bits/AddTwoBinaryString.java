package com.bits;

/**
 * Created by sudhirmiglani on 11/06/16.
 */
public class AddTwoBinaryString {

    public static String addBitStrings(String first, String second) {
        String result = "";  // To store the sum bits

        // make the lengths same before adding
        int len1 = first.length();
        int len2 = second.length();
        if (len1 < len2) {
            for (int i = 0; i < len2 - len1; i++)
                first = '0' + first;
        } else if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++)
                second = '0' + second;
        }

        int length = first.length();
        int carry = 0;  // Initialize carry

        // Add all bits one by one
        for (int i = length - 1; i >= 0; i--) {
            int firstBit = first.charAt(i) - '0';
            int secondBit = second.charAt(i) - '0';

            // boolean expression for sum of 3 bits
            int sum = (firstBit ^ secondBit ^ carry);

            result = sum + result;

            // boolean expression for 3-bit addition
            carry = (firstBit & secondBit) | (secondBit & carry) | (firstBit & carry);
        }

        // if overflow, then add a leading 1
        if (carry == 1)
            result = '1' + result;

        return result;
    }

    public static void main(String args[]) {
        String str1 = "1100011";
        String str2 = "10";

        System.out.println(addBitStrings(str1, str2));
    }
}

