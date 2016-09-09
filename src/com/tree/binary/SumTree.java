package com.tree.binary;

/**
 * Created by sudhirmiglani on 14/04/16.
 */
public class SumTree {

    private Node root;

    public SumTree() {
        root = null;
    }

    public void printInOrder() {
        System.out.println("printInOrder");
        printInOrder(this.root);
    }

    private void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }


    public void printSumTree() {
        printSumTree(this.root);
    }

    private void printSumTree(Node node) {

        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            return;
        }
//        if (node.left == null){
//            return node.
//        }

        printSumTree(node.left);
        printSumTree(node.right);

        if (node.left != null) {
            node.data = node.right.data;
        }
        if (node.right == null) {
            node.data = node.left.data;
        }
        node.data = node.left.data + node.right.data;
        //return node.data;
    }


    public static void main(String args[]) {
        SumTree sumTree = new SumTree();
        sumTree.root = new Node(1);
        sumTree.root.left = new Node(2);
        sumTree.root.right = new Node(3);
        sumTree.root.left.left = new Node(4);
        sumTree.root.left.right = new Node(5);
        sumTree.printInOrder();
        sumTree.printSumTree();
        sumTree.printInOrder();
    }
}
