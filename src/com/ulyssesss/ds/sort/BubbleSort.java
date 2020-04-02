package com.ulyssesss.ds.sort;

public class BubbleSort {

    public void sort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean finish = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    finish = false;
                }
            }
            if (finish) {
                break;
            }
        }
    }
}
