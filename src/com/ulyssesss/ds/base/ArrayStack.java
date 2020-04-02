package com.ulyssesss.ds.base;

/**
 * 栈 - 数组实现
 *
 * @author jiangyue
 */
public class ArrayStack {

    private int capacity;

    private int topIndex;

    private int[] array;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.topIndex = -1;
        this.array = new int[capacity];
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public boolean isFullStack() {
        return topIndex == capacity -1;
    }

    public void push(int data) {
        if (isFullStack()) {
            System.out.println("stack overflow");
        } else {
            array[++topIndex] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return 0;
        } else {
            return array[topIndex--];
        }
    }

    public void clearStack() {
        topIndex = -1;
    }
}
