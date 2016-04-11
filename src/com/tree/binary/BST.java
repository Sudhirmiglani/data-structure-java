package com.tree.binary;

/**
 * Created by sudhirmiglani on 11/04/16.
 */
public class BST {

    Node root;

    public BST() {
        root = null;
    }

    public void insert(int data) {
        this.root = insert(this.root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);

        } else {
            if (node.data > data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    public void printInOrder() {
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

    public void search(int data){
        Node node = search(this.root, data);
        if(node == null){
            System.out.println("Not found");
        }else{
            System.out.println("Found element " + node.data);
        }
    }

    private Node search(Node node, int data){
        if(node == null){
            return null;
        }
        if(node.data == data){
            return node;
        }
        if(node.data > data){
            return search(node.left, data);
        }else{
            return search(node.right, data);
        }
    }

    public static void main(String args[]) {
        BST bst = new BST();
        for (int i = 1; i <= 6; i++) {
            bst.insert(i);
        }
        bst.printInOrder();
        bst.search(5);
        bst.search(7);

    }

}
