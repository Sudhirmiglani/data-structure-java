package com.tree.binary;

import java.util.Stack;

/**
 * Created by sudhirmiglani on 14/04/16.
 */
public class PrintSpiral {

    Node root;

    public PrintSpiral() {
        root = null;
    }

    private int height(Node root) {
        if (root == null) {
            return 0;
        } else {
            int l = height(root.left);
            int r = height(root.right);

            return (l > r ? l : r) + 1;
        }
    }

    public void printLevelOrder() {
        int h = height(this.root);
        boolean toggle = false;
        for(int i = 1; i<= h; i++){
            printLevelOrder(this.root, i, toggle);
            toggle = !toggle;
        }
    }

    private void printLevelOrder(Node root, int level, boolean toggle) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.data);
            return;
        }
        if (toggle) {
            printLevelOrder(root.left, level - 1, toggle);
            printLevelOrder(root.right, level - 1, toggle);
        } else {
            printLevelOrder(root.right, level - 1, toggle);
            printLevelOrder(root.left, level - 1, toggle);
        }

    }

    public void printSpiralWithStack(){
        printSpiralWithStack(this.root);
    }

    private void printSpiralWithStack(Node node){
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        if(node == null){
            return;
        }
        stack1.push(node);

        while (!stack1.empty() || !stack2.empty()){

            while (!stack1.empty()){
                Node temp = stack1.pop();
                System.out.print(temp.data);
                if(temp.left != null){
                    stack2.push(temp.left);
                }
                if(temp.right != null){
                    stack2.push(temp.right);
                }
            }
            while (!stack2.empty()){
                Node temp = stack2.pop();
                System.out.print(temp.data);
                if(temp.right != null){
                    stack1.push(temp.right);
                }
                if(temp.left != null){
                    stack1.push(temp.left);
                }
            }

        }



    }

    public static void main(String args[]) {
        PrintSpiral printSpiral = new PrintSpiral();
        printSpiral.root = new Node(1);
        printSpiral.root.left = new Node(2);
        printSpiral.root.right = new Node(3);
        printSpiral.root.left.left = new Node(4);
        printSpiral.root.left.right = new Node(5);
        //printSpiral.printLevelOrder();
        printSpiral.printSpiralWithStack();

    }
}
