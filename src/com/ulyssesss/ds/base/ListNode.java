package com.ulyssesss.ds.base;

/**
 * 单链表结点
 *
 * @author jiangyue
 */
public class ListNode {

    private int data;

    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void traversal() {
        ListNode currentNode = this;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public int length() {
        int length = 0;
        ListNode currentNode = this;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        return length;
    }

    public ListNode insert(int targetPosition, ListNode nodeToInsert) {
        int length = length();
        if (targetPosition < 0 || targetPosition > length) {
            System.out.println("position error");
            return this;
        }
        if (targetPosition == 0) {
            nodeToInsert.next = this;
            return nodeToInsert;
        } else {
            ListNode previousNode = this;
            for (int i = 1; i < targetPosition; i++) {
                previousNode = previousNode.next;
            }
            nodeToInsert.next = previousNode.next;
            previousNode.next = nodeToInsert;
            return this;
        }
    }

    public ListNode delete(int position) {
        int length = length();
        if (position < 0 || position >= length) {
            System.out.println("position error");
            return this;
        }
        if (position == 0) {
            ListNode head = this.next;
            this.next = null;
            return head;
        } else {
            ListNode previousNode = this;
            for (int i = 1; i < position; i++) {
                previousNode = previousNode.next;
            }
            ListNode currentNode = previousNode.next;
            previousNode.next = currentNode.next;
            currentNode.next = null;
            return this;
        }
    }
}
