package com.ulyssesss.ds;

/**
 * 栈 - 动态数组实现
 *
 * @author jiangyue
 */
public class DynArrayStack {

    private int capacity;

    private int topIndex;

    private int[] array;

    public DynArrayStack(int capacity) {
        this.capacity = capacity;
        this.topIndex = -1;
        this.array = new int[capacity];
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public boolean isFullStack() {
        return topIndex == capacity - 1;
    }

    public void push(int data) {
        if (isFullStack()) {
            int[] newArray = new int[capacity * 2];
            System.arraycopy(array, 0, newArray, 0, capacity);
            capacity = capacity * 2;
            array = newArray;
        }
        array[++topIndex] = data;

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
