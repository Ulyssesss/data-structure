package com.ulyssesss.ds.base;

/**
 * 双向链表结点 - Double Linked List Node
 *
 * @author jiangyue
 */
public class DLLNode {

    private int data;

    private DLLNode previous;

    private DLLNode next;

    public DLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public void traversal() {
        DLLNode currentNode = this;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public int length() {
        int length = 0;
        DLLNode currentNode = this;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }

    public DLLNode insert(int targetPosition, DLLNode nodeToInsert) {
        int length = length();
        if (targetPosition < 0 || targetPosition > length) {
            System.out.println("position error");
            return this;
        }
        if (targetPosition == 0) {
            nodeToInsert.next = this;
            this.previous = nodeToInsert;
            return nodeToInsert;
        } else {
            DLLNode previousNode = this;
            for (int i = 1; i < targetPosition; i++) {
                previousNode = previousNode.next;
            }
            DLLNode currentNode = previousNode.next;
            nodeToInsert.next = currentNode;
            previousNode.next = nodeToInsert;
            nodeToInsert.previous = previousNode;
            if (currentNode != null) {
                currentNode.previous = nodeToInsert;
            }
            return this;
        }
    }

    public DLLNode delete(int position) {
        int length = length();
        if (position < 0 || position >= length) {
            System.out.println("position error");
            return this;
        }
        if (position == 0) {
            DLLNode head = this.next;
            head.previous = null;
            this.next = null;
            return head;
        } else {
            DLLNode previousNode = this;
            for (int i = 1; i < position; i++) {
                previousNode = previousNode.next;
            }
            DLLNode currentNode = previousNode.next;
            DLLNode nextNode = currentNode.next;
            previousNode.next = nextNode;
            if (nextNode != null) {
                nextNode.previous = previousNode;
            }
            currentNode.previous = null;
            currentNode.next = null;
            return this;
        }
    }
}
