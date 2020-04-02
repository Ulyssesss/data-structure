package com.ulyssesss.ds.base;

import java.util.Arrays;

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

    public BinaryHeap(int[] items) {
        size = items.length;
        array = new int[items.length * 2 + 1];
        System.arraycopy(items, 0, array, 1, items.length);
        buildHeap();
    }

    public void insert(int x) {
        if (size == array.length - 1) {
            array = Arrays.copyOf(array, array.length * 2 + 1);
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

    private void buildHeap() {
        for (int i = size / 2; i > 0; i--) {
            percolateDown(i);
        }
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
}
