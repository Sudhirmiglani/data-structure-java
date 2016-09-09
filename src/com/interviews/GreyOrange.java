package com.interviews;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by sudhirmiglani on 20/07/16.
 */
class Node {

    private char value; // stores character
    private HashMap<Character, Node> children; // children of this node
    private boolean isEnd; // flag to detech the end of the word
    private int frequency; // frequency of the particular word ( only applicable if isEnd is true )
    private int heapIndex; // index to detect whether this word is present in heap or not

    public Node(char ch) {
        value = ch;
        children = new HashMap<>();
        isEnd = false;
        frequency = 0;
        heapIndex = -1;
    }

    HashMap<Character, Node> getChildren() {
        return children;
    }

    public void setIsEnd(boolean val) {
        isEnd = val;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int f) {
        frequency = f;
    }

    public int getHeapIndex() {
        return heapIndex;
    }

    public void setHeapIndex(int heapIndex) {
        this.heapIndex = heapIndex;
    }


}

class Trie {

    private Node root;

    public Trie() {
        root = new Node((char) 0);
    }

    // inserts word in Trie, if its already present then increase the frequency
    // otherwise set the frequency to 1
    public Node insertWord(String str) {

        int length = str.length();
        Node crawl = root;

        for (int i = 0; i < length; i++) {
            HashMap<Character, Node> child = crawl.getChildren();
            char ch = str.charAt(i);

            if (child.containsKey(ch))
                crawl = child.get(ch);
            else {
                Node temp = new Node(ch);
                child.put(ch, temp);
                crawl = temp;
            }
        }
        if (crawl.isEnd()) {
            crawl.setFrequency(crawl.getFrequency() + 1);
        } else {
            crawl.setFrequency(1);
            crawl.setIsEnd(true);
        }
        return crawl;
    }
}

// Heap element, can be other data also apart from String
class HeapElement {
    private String str;
    private int frequency; // used while heapify
    private Node node; // reference to the leaf node in the Trie ( used to update the heapIndex of the node )

    HeapElement(String str, int frequency, Node node) {
        this.str = str;
        this.frequency = frequency;
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public String getStr() {
        return str;

    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setStr(String str) {
        this.str = str;
    }

}

public class GreyOrange {


    private static void topK(String str, int k) {

        String words[] = str.split(" ");

        HeapElement arr[] = new HeapElement[k];

        Trie trie = new Trie();

        int i = 0;
        for (String s : words) {
            Node node = trie.insertWord(s);

            if (node.getHeapIndex() != -1) {
                HeapElement element = arr[node.getHeapIndex()];
                element.setFrequency(node.getFrequency());
                heapify(arr, node.getHeapIndex(), i);
            } else if (i < k) {
                arr[i] = new HeapElement(s, node.getFrequency(), node);
                node.setHeapIndex(i);
                i++;
                heapify(arr, i - 1, i);
            } else if (node.getFrequency() > arr[0].getFrequency()) {
                arr[0] = new HeapElement(s, node.getFrequency(), node);
                heapify(arr, 0, k);
            }
        }

        System.out.println("Top " + k + " elements are : ");
        for (int l = 0; l < k; l++) {

            // if we require top k elements in the order,
            // we have to call heapify again after removing each element from the min heap
            HeapElement element = extractMin(arr, k - l);
            System.out.println(element.getStr() + " -> " + element.getFrequency());

        }

    }

    public static void readFile(String filePath, int k) {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String currentLine;
            HeapElement arr[] = new HeapElement[k];

            Trie trie = new Trie();

            int i = 0;
            while ((currentLine = br.readLine()) != null) {
                String words[] = currentLine.split(" ");


                    for (String s : words) {
                        Node node = trie.insertWord(s);

                        if (node.getHeapIndex() != -1) {
                            HeapElement element = arr[node.getHeapIndex()];
                            element.setFrequency(node.getFrequency());
                            heapify(arr, node.getHeapIndex(), i);
                        } else if (i < k) {
                            arr[i] = new HeapElement(s, node.getFrequency(), node);
                            node.setHeapIndex(i);
                            i++;
                            heapify(arr, i - 1, i);
                        } else if (node.getFrequency() > arr[0].getFrequency()) {
                            arr[0] = new HeapElement(s, node.getFrequency(), node);
                            heapify(arr, 0, k);
                        }
                    }


            }

            System.out.println("Top " + k + " elements are : ");
            for (int l = 0; l < k; l++) {

                // if we require top k elements in the order,
                // we have to call heapify again after removing each element from the min heap
                HeapElement element = extractMin(arr, k - l);
                System.out.println(element.getStr() + " -> " + element.getFrequency());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HeapElement extractMin(HeapElement[] arr, int size) {
        HeapElement root = arr[0];
        if (size > 1) {
            arr[0] = arr[size - 1];
            size--;
            heapify(arr, 0, size);
        }
        return root;
    }

    public static void heapify(HeapElement[] arr, int i, int size) {

        int smallest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (((left < size) && (arr[left].getFrequency() < arr[i].getFrequency()))) {
            smallest = left;
        }

        if (((right < size) && (arr[right].getFrequency() < arr[smallest].getFrequency()))) {
            smallest = right;
        }
        if (smallest != i) {

            arr[i].getNode().setHeapIndex(smallest);
            arr[smallest].getNode().setHeapIndex(i);

            swap(arr, i, smallest);
            heapify(arr, smallest, size);
        }
    }

    private static void swap(HeapElement[] arr, int i, int largest) {
        HeapElement t = arr[i];
        arr[i] = arr[largest];
        arr[largest] = t;

    }


    public static void main(String ar[]) {

        String str = "Hi this is Hi Sudhir this Miglani Hi is Sudhir the because of of man this is real shit. Fu**ing awesome";

        // test with String input
        topK(str, 5);

        // change FilePath here...
        //readFile("/Users/sudhirmiglani/Desktop/Test.txt", 5);


    }
}
