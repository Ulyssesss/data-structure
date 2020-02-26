package com.ulyssesss.ds;

/**
 * 二叉堆
 */
public class BinaryHeap {

    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    private int[] array;

    public BinaryHeap() {
        size = 0;
        array = new int[DEFAULT_CAPACITY];
    }

    public void insert(int x) {
        if (size == array.length - 1) {
            enlargeArray(array.length * 2 + 1);
        }
        int hole = ++size;
        for (array[0] = x; x < array[hole / 2]; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }

    public int deleteMin() {
        if (size == 0) {
            System.out.println("heap is empty");
            return -1;
        }
        int min = array[1];
        array[1] = array[size--];
        percolateDown(1);
        return min;
    }

    private void percolateDown(int hole) {
        int temp = array[hole];
        int child;
        while (hole * 2 < size) {
            child = hole * 2;
            if (child < size && array[child + 1] < array[child]) {
                child++;
            }
            if (temp < array[child]) {
                array[hole] = array[child];
            } else {
                break;
            }
            hole = child;
        }
        array[hole] = temp;
    }

    private void enlargeArray(int i) {
        //...
    }
}
