package ru.itpark;

public class MergeSort {
    public static int[] sort(int a[], int b[]) {
        int c[] = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] >= b[j]) {
                c[k] = b[j];
                j++;
            } else {
                c[k] = a[i];
                i++;
            }
            k++;
        }

        while (i < a.length) {
            c[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            c[k] = b[j];
            j++;
            k++;
        }

        return c;
    }
}
