package com.tree.binary;

import java.util.Stack;

/**
 * Created by sudhirmiglani on 11/04/16.
 */
public class InorderWithoutRecursion {

    private Node root;

    public InorderWithoutRecursion() {
        this.root = null;
    }

    public void inOrderWithoutRecursion() {
        inOrderWithoutRecursion(this.root);
    }

    private void inOrderWithoutRecursion(Node node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();

        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (stack.size() > 0) {
            Node temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                temp = temp.right;
                stack.push(temp);
                while (temp.left != null) {
                    stack.push(temp.left);
                    temp = temp.left;
                }
            }
        }
    }

    public static void main(String args[]) {
        InorderWithoutRecursion inorderWithoutRecursion = new InorderWithoutRecursion();
        inorderWithoutRecursion.root = new Node(1);
        inorderWithoutRecursion.root.left = new Node(2);
        inorderWithoutRecursion.root.right = new Node(3);
        inorderWithoutRecursion.root.left.left = new Node(4);
        inorderWithoutRecursion.root.left.right = new Node(5);
        inorderWithoutRecursion.root.right.right = new Node(6);
        inorderWithoutRecursion.root.right.right.right = new Node(7);
        inorderWithoutRecursion.inOrderWithoutRecursion();
    }
}
