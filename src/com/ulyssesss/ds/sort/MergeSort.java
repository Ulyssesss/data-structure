package com.ulyssesss.ds.sort;

public class MergeSort {

    public void sort(int[] a, int n) {
        mergeSort(a, 0, n - 1);
    }

    private void mergeSort(int[] a, int beginIndex, int endIndex) {
        if (beginIndex >= endIndex) {
            return;
        }
        int midIndex = beginIndex + (endIndex - beginIndex) / 2;
        mergeSort(a, beginIndex, midIndex);
        mergeSort(a, midIndex + 1, endIndex);
        merge(a, beginIndex, midIndex, midIndex + 1, endIndex);
    }

    private void merge(int[] a, int beginIndex1, int endIndex1, int beginIndex2, int endIndex2) {
        int[] temp = new int[a.length];
        int current = beginIndex1;
        int beginIndex = beginIndex1;
        while (beginIndex1 <= endIndex1 && beginIndex2 <= endIndex2) {
            temp[current++] = a[beginIndex1] <= a[beginIndex2] ? a[beginIndex1++] : a[beginIndex2++];
        }
        while (beginIndex1 <= endIndex1) {
            temp[current++] = a[beginIndex1++];
        }
        while (beginIndex2 <= endIndex2) {
            temp[current++] = a[beginIndex2++];
        }
        System.arraycopy(temp, beginIndex, a, beginIndex, endIndex2 + 1 - beginIndex);
    }
}
