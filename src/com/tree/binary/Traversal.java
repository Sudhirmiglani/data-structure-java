package com.tree.binary;

/**
 * Created by sudhirmiglani on 23/03/16.
 */


public class Traversal {

    Node root;

    Traversal() {
        root = null;
    }

    public void printPostOrder() {
        System.out.println("printPostOrder");
        printPostOrder(this.root);
    }

    private void printPostOrder(Node root) {
        if (root == null) {
            return;
        }

        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void printInOrder() {
        System.out.println("printInOrder");
        printInOrder(this.root);
    }

    private void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printPostOrder(root.left);
        System.out.print(root.data + " ");
        printPostOrder(root.right);
    }

    public void printPreOrder() {
        System.out.println("printPreOrder");
        printPreOrder(this.root);
    }

    private void printPreOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        printPostOrder(root.left);
        printPostOrder(root.right);
    }


    public static void main(String ar[]) {
        Traversal traversal = new Traversal();
        traversal.root = new Node(1);
        traversal.root.left = new Node(2);
        traversal.root.right = new Node(3);
        traversal.root.left.left = new Node(4);
        traversal.root.left.right = new Node(5);
        traversal.printPostOrder();
        traversal.printInOrder();
        traversal.printPreOrder();
    }


}