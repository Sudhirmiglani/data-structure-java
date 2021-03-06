package com.linkedlist;

/**
 * Created by sudhirmiglani on 02/04/16.
 */
public class LinkedList {

    private Node head;

    private static class Node {
        Node next;
        int data;

        Node(int newData) {
            next = null;
            data = newData;
        }
    }

    public void LinkedList() {
        head = null;
    }

    public void insert(int data) {
        head = insert(head, data);
    }

    private Node insert(Node node, int data) {
        Node temp;
        if (node == null) {
            node = new Node(data);
        } else {
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }

        return (node); // in any case, return the new pointer to the caller
    }

    public void printList() {
        printList(head);
    }

    private void printList(Node node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.print(node.data + "\t");
            node = node.next;
        }
    }

    public void delete(int data) {
        head = delete(head, data);
    }

    private Node delete(Node node, int data) {
        if (node == null) {
            return node;
        }

        // check for head
        if (node.data == data) {
            return node.next;
        } else {
            Node prev = node;
            Node temp = node.next;
            while (temp != null) {
                if (temp.data == data) {
                    prev.next = temp.next;
                    temp.next = null;
                    break;
                } else {
                    prev = temp;
                    temp = temp.next;
                }
            }
        }
        return node;

    }

    public int length() {
        return lengthIterative(head);
    }

    private int lengthIterative(Node node) {
        int len = 0;
        Node temp = node;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    private int lengthRecursive(Node node) {
        if (node == null) {
            return 0;
        }
        return lengthRecursive(node.next) + 1;
    }

    public void swap(int data1, int data2) {
        head = swap(head, data1, data2);
    }

    private Node swap(Node node, int data1, int data2) {
        Node prev1 = null, prev2 = null;
        //boolean isFirstFound = false, isSecondFound = false;
        if (node == null || node.next == null || data1 == data2) {
            return node;
        }
        Node temp1 = node, temp2 = node;
        while (temp1 != null && temp1.data != data1) {
            prev1 = temp1;
            temp1 = temp1.next;
        }
        while (temp2 != null && temp2.data != data2) {
            prev2 = temp2;
            temp2 = temp2.next;
        }

        // one of the data , not found
        if (temp1 == null || temp2 == null) {
            return node;
        }

        if (prev1 != null) {
            prev1.next = temp2;
        } else {
            node = temp2;
        }

        if (prev2 != null) {
            prev2.next = temp1;
        } else {
            node = temp1;
        }

        // swap next pointers
        Node swap = temp2.next;
        temp2.next = temp1.next;
        temp1.next = swap;

        return node;
    }

    public void getKthNodeFromLast(int k) {
        Node n = getKthNodeFromLast(head, k);
        if (n != null) {
            System.out.println("Nth Node from end " + n.data);
        } else {
            System.out.println("Nth Node from end not found");
        }
    }

    private Node getKthNodeFromLast(Node node, int k) {
        if (node == null) {
            return null;
        }

        int n = this.lengthIterative(node);
        if (n < k) {
            return null;
        }
        int len = n - k;
        Node ptr = node;
        for (int i = 1; i <= len; i++) {
            ptr = ptr.next;
        }
        return ptr;

    }

    public void getMiddleElement() {
        Node n = getMiddleElement(head);
        if (n != null) {
            System.out.println("Middle element " + n.data);
        } else {
            System.out.println("Middle element not found");
        }
    }

    private Node getMiddleElement(Node node) {
        Node slow = node, fast = node;
        if (node == null || node.next == null) {
            return null;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void reversal() {
        head = reversal(head);
    }

    private Node reversal(Node node) {
        if (node == null) {
            return node;
        }
        Node current = node, prev = null, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public boolean isPalindrome() {
        return isPalindrome(head);
    }

    private boolean isPalindrome(Node node) {
        if (node == null || node.next == null) {
            return true;
        }

        // find middle of linked list
        Node slow = node, fast = node, middle = null, middlePrev = null;

        while (fast != null && fast.next != null) {
            middlePrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // odd number of nodes
        if (fast != null) {
            middle = slow;
            slow = slow.next;
            middle.next = null;
        }
        middlePrev.next = null;
        Node ptr1 = node;
        slow = reversal(slow);
        Node ptr2 = slow;
        while (ptr1 != null && ptr2 != null && ptr1.data == ptr2.data) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        if (ptr1 != null || ptr2 != null) {
            return false;
        }

        // remake the list
        ptr1 = node;
        ptr2 = slow;
        while (ptr1.next != null) {
            ptr1 = ptr1.next;
        }
        if (middle != null) {
            ptr1.next = middle;
            ptr1 = ptr1.next;
        }
        ptr1.next = reversal(ptr2);

        return true;
    }

    public void mergeSortedLL(LinkedList list1, LinkedList list2) {
        Node node = mergeSortedLinkedList(list1.head, list2.head);
        System.out.println("Merged list ");
        printList(node);
        System.out.println("Individual lists");
        printList(list1.head);
        System.out.println("Individual lists");
        printList(list2.head);
        // System.out.print("");
    }

    private Node mergeSortedLinkedList(Node n1, Node n2) {
        Node temp = null, head = null;
        Node node1 = n1, node2 = n2;
        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                if (temp == null) {
                    temp = node1;
                    head = temp;
                    node1 = node1.next;
                    temp.next = null;
                } else {
                    temp.next = node1;
                    temp = temp.next;
                    node1 = node1.next;
                }
            } else {
                if (temp == null) {
                    temp = node2;
                    head = temp;
                    node2 = node2.next;
                    temp.next = null;
                } else {
                    temp.next = node2;
                    temp = temp.next;
                    node2 = node2.next;
                }
            }
        }
        if (node1 != null) {
            temp.next = node1;
        }
        if (node2 != null) {
            temp.next = node2;
        }

        return head;
    }


    public static void main(String args[]) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(3);
        linkedList.insert(2);
        linkedList.insert(1);
//        linkedList.insert(5);
//        linkedList.insert(6);
        //linkedList.delete(6);
        linkedList.printList();
        System.out.println();
        System.out.println("Length of link list " + linkedList.length());

        //System.out.println("Swap");
        linkedList.swap(6, 1);
        //linkedList.printList();
        //System.out.println("Get kth node from last ");
        //linkedList.getKthNodeFromLast(6);
        //linkedList.getMiddleElement();
        // linkedList.reversal();
        // System.out.println("reversal ");
        // linkedList.printList();
        //System.out.println("Is palindrome " + linkedList.isPalindrome());
        //linkedList.printList();


        LinkedList linkedList1 = new LinkedList();
        linkedList1.insert(1);
        linkedList1.insert(3);
        linkedList1.insert(5);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insert(2);
        linkedList2.insert(4);

        linkedList.mergeSortedLL(linkedList1, linkedList2);

    }


}
