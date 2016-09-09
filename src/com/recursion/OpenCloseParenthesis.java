package com.recursion;

/**
 * Created by sudhirmiglani on 23/07/16.
 */
public class OpenCloseParenthesis {

    private static String openString = "<";
    private static String ClosedString = ">";

    static void brackets(int openStock, int closeStock, String s) {
        if (openStock == 0 && closeStock == 0) {
            System.out.println(s);
        }
        if (openStock > 0) {
            brackets(openStock - 1, closeStock + 1, s + openString);
        }
        if (closeStock > 0) {
            brackets(openStock, closeStock - 1, s + ClosedString);
        }
    }

    public static void main(String ar[]) {
        brackets(3, 0, "");
    }
}
