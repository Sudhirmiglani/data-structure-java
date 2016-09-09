package com.tree.binary;

/**
 * Created by sudhirmiglani on 12/04/16.
 */
public class TreeMirror {
    
    private Node root;
    
    public TreeMirror(){
        root = null;
    }
    
    public void convertToMirror(){
        convertToMirror(this.root);
    }
    private void convertToMirror(Node node){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            return;
        }

        convertToMirror(node.left);
        convertToMirror(node.right);

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
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
    
    public static void main(String args[]){
        TreeMirror treeMirror = new TreeMirror();
        treeMirror.root = new Node(1);
        treeMirror.root.left = new Node(2);
        treeMirror.root.right = new Node(3);
        treeMirror.root.left.left = new Node(4);
        treeMirror.root.left.right = new Node(5);
        treeMirror.root.right.right = new Node(6);
        treeMirror.root.right.right.right = new Node(7);

        treeMirror.printInOrder();

        treeMirror.convertToMirror();

        treeMirror.printInOrder();

    }
}

