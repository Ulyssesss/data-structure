package com.ulyssesss.ds.base;

/**
 * 队列 - 链表实现 Linked List Queue
 *
 * @author jiangyue
 */
public class LLQueue {

    private ListNode front;
    private ListNode rear;
    private int size;

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public void enQueue(int data) {
        ListNode newNode = new ListNode(data);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return 0;
        } else {
            int result = front.getData();
            if (front == rear) {
                rear = null;
            }
            front = front.getNext();
            return result;
        }
    }
}
