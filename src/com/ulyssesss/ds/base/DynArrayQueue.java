package com.ulyssesss.ds.base;

/**
 * 队列 - 动态循环数组实现
 *
 * @author jiangyue
 */
public class DynArrayQueue {

    private int front;

    private int rear;

    private int[] array;

    private int capacity;

    public DynArrayQueue(int capacity) {
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
            resize();
        }
        rear = (rear + 1) % capacity;
        array[rear] = data;
    }

    private void resize() {
        int[] newArray = new int[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            newArray[i] = array[front];
            front = (front + 1) % capacity;
        }
        front = 0;
        rear = capacity - 1;
        array = newArray;
        capacity = capacity * 2;
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
