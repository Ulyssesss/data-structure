package com.ulyssesss.ds.sort;

public class QuickSort {

    public void sort(int[] a, int n) {
        quickSort(a, 0, n - 1);
    }

    private void quickSort(int[] a, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivotIndex = partition(a, begin, end);
        quickSort(a, begin, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, end);
    }

    private int partition(int[] a, int begin, int end) {
        int pivot = a[end];
        int index = begin;
        int temp;
        for (int current = begin; current <= end; current++) {
            if (a[current] < pivot) {
                temp = a[index];
                a[index] = a[current];
                a[current] = temp;
                index++;
            }
        }
        temp = a[index];
        a[index] = a[end];
        a[end] = temp;
        return index;
    }
}
