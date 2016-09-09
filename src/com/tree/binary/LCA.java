package com.tree.binary;

/**
 * Created by sudhirmiglani on 23/05/16.
 */
public class LCA {

    Node root;

    LCA() {
        root = null;
    }

    public int getLCA(){
        return -1;
    }

    private Node getLCA(Node node1, Node node2){
        if(node1 == null || node2 == null){
            return null;
        }

        return null;


    }


    public static void main(String ar[]) {
        LCA lca = new LCA();
        lca.root = new Node(1);
        lca.root.left = new Node(2);
        lca.root.right = new Node(3);
        lca.root.left.left = new Node(4);
        lca.root.left.right = new Node(5);
    }

}
