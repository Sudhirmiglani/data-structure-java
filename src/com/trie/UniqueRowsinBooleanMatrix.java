package com.trie;

import java.util.HashMap;

/**
 * Created by sudhirmiglani on 01/08/16.
 */

class Node {

    private boolean value;
    private HashMap<Boolean, Node> children;
    private boolean isEnd;

    Node(int val) {
        value = (val == 1);
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public HashMap<Boolean, Node> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Boolean, Node> children) {
        this.children = children;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}

class Trie {

    private Node root;

    public void insertWord(int[][] arr, int rowNumber, int colNumber) {

        if (root == null) {
            root = new Node(arr[rowNumber][colNumber]);
        }

//        int length = str.length();
//        Node crawl = root;
//
//        for (int i = 0; i < length; i++) {
//            HashMap<Character, Node> child = crawl.getChildren();
//            char ch = str.charAt(i);
//
//            if (child.containsKey(ch))
//                crawl = child.get(ch);
//            else {
//                Node temp = new Node(ch);
//                child.put(ch, temp);
//                crawl = temp;
//            }
//        }
//        crawl.setIsEnd(true);
    }
}

public class UniqueRowsinBooleanMatrix {


    public static void main(String ar[]) {

    }

}
