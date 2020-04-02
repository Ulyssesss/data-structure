package com.ulyssesss.ds.base;

/**
 * 队列 - 简单循环数组实现
 *
 * @author jiangyue
 */
public class ArrayQueue {

    private int front;

    private int rear;

    private int[] array;

    private int capacity;

    public ArrayQueue(int capacity) {
        this.front = -1;
        this.rear = -1;
        this.array = new int[capacity];
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFullQueue() {
        return (rear + 1) % capacity == front;
    }

    public int size() {
        if (front == -1) {
            return 0;
        }
        int size = rear - front + 1;
        if (size <= 0) {
            size += capacity;
        }
        return size;
    }

    public void enQueue(int data) {
        if (isFullQueue()) {
            System.out.println("queue overflow");
        } else {
            rear = (rear + 1) % capacity;
            array[rear] = data;
            if (front == -1) {
                front = rear;
            }
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return 0;
        } else if (front == rear) {
            int result = array[front];
            front = -1;
            rear = -1;
            return result;
        } else {
            int result = array[front];
            front = (front + 1) % capacity;
            return result;
        }
    }
}
