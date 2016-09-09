package com.tree.binary;

/**
 * Created by sudhirmiglani on 12/04/16.
 */
public class IsTreeSame {

    private Node root;

    public IsTreeSame() {
        this.root = null;
    }

    public boolean isTreeSame(Node node) {

        return isTreeSame(this.root, node);
    }

    private boolean isTreeSame(Node node1, Node node2) {

        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }
        return node1.data == node2.data && isTreeSame(node1.left, node2.left) && isTreeSame(node1.right, node2.right);
    }

    public static void main(String args[]) {
        IsTreeSame isTreeSame = new IsTreeSame();
        isTreeSame.root = new Node(1);
        isTreeSame.root.left = new Node(2);
        isTreeSame.root.right = new Node(3);
        isTreeSame.root.left.left = new Node(4);
        isTreeSame.root.left.right = new Node(5);
        isTreeSame.root.right.right = new Node(6);
        isTreeSame.root.right.right.right = new Node(7);

        IsTreeSame isTreeSame2 = new IsTreeSame();
        isTreeSame2.root = new Node(1);
        isTreeSame2.root.left = new Node(2);
        isTreeSame2.root.right = new Node(3);
        isTreeSame2.root.left.left = new Node(4);
        isTreeSame2.root.left.right = new Node(5);
        isTreeSame2.root.right.right = new Node(6);
        isTreeSame2.root.right.right.right = new Node(7);

        System.out.print("isTreeSame -> " + isTreeSame.isTreeSame(isTreeSame2.root));
    }
}
