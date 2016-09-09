package com.stack;

import java.util.Stack;

/**
 * Created by sudhirmiglani on 08/08/16.
 */
public class SpecialStack {

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();


    private static void addElement(int n) {
        if (stack1.isEmpty()) {
            stack1.push(n);
            stack2.push(n);
        } else {
            stack1.push(n);
            int y = stack2.peek();
            if (n <= y) {
                stack2.push(n);
            }
        }
    }

    private static int pop() {
        int x = stack1.pop();
        if (x == stack2.peek()) {
            stack2.pop();
        }
        return x;
    }

    private static int getMin() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        return -1;
    }


    public static void main(String ar[]) {
        addElement(4);
        System.out.print("Stack 1 - > " + stack1);
        System.out.print("Stack 2 - > " + stack2);
        System.out.print("---------");

        addElement(2);
        System.out.print("Stack 1 - > " + stack1);
        System.out.print("Stack 2 - > " + stack2);
        System.out.print("---------");

        addElement(2);
        System.out.print("Stack 1 - > " + stack1);
        System.out.print("Stack 2 - > " + stack2);
        System.out.print("---------");

        addElement(5);
        System.out.print("Stack 1 - > " + stack1);
        System.out.print("Stack 2 - > " + stack2);
        System.out.print("---------");

        addElement(3);
        System.out.print("Stack 1 - > " + stack1);
        System.out.print("Stack 2 - > " + stack2);
        System.out.print("---------");

        addElement(1);
        System.out.print("Stack 1 - > " + stack1);
        System.out.print("Stack 2 - > " + stack2);
        System.out.print("---------");

        pop();
        System.out.print("Stack 1 - > " + stack1);
        System.out.print("Stack 2 - > " + stack2);
        System.out.print("---------");

        pop();
        System.out.print("Stack 1 - > " + stack1);
        System.out.print("Stack 2 - > " + stack2);
        System.out.print("---------");

        getMin();
        System.out.print("Stack 1 - > " + stack1);
        System.out.print("Stack 2 - > " + stack2);
        System.out.print("---------");
    }
}
