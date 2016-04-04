package com.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sudhirmiglani on 23/03/16.
 */


public class BFS {

    Node root;

    BFS() {
        root = null;
    }

    private int height(Node root){

        if(root == null){
            return 0;
        }else{
            int l = height(root.left);
            int r = height(root.right);

            return (l > r ? l : r) + 1;
        }

    }

    public void levelOrder(){
        levelOrder(this.root);
    }

    private void printGivenLevel(Node root, int level){
        if(root == null){
            return;
        }
        if(level == 1){
            System.out.print(root.data + " ");
        }else{
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }

    private void levelOrder(Node root){
        int h = height(root);
        for(int i = 1;i <= h ; i++){
            printGivenLevel(root, i);
        }
    }

    public void levelOrderUsingQueue(){

    }

    private void levelOrderUsingQueue(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //Node temp
        }

    }


    public static void main(String ar[]) {
        BFS traversal = new BFS();
        traversal.root = new Node(1);
        traversal.root.left = new Node(2);
        traversal.root.right = new Node(3);
        traversal.root.left.left = new Node(4);
        traversal.root.left.right = new Node(5);
        traversal.levelOrder();
    }


}
