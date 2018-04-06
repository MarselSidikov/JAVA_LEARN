package ru.itpark;

public class MergeSort {
//    public static int[] sort(int a[], int b[]) {
//        int c[] = new int[a.length + b.length];
//
//        int i = 0;
//        int j = 0;
//        int k = 0;
//
//        while (i < a.length && j < b.length) {
//            if (a[i] >= b[j]) {
//                c[k] = b[j];
//                j++;
//            } else {
//                c[k] = a[i];
//                i++;
//            }
//            k++;
//        }
//
//        while (i < a.length) {
//            c[k] = a[i];
//            i++;
//            k++;
//        }
//
//        while (j < b.length) {
//            c[k] = b[j];
//            j++;
//            k++;
//        }
//
//        return c;
//    }

    private static int helpArray[];

    static {
        helpArray = new int[200];
    }

    public static void sort(int array[], int lower, int higher) {
        LogUtils.log(array, "sort", lower, higher);

        if (higher <= lower) {
            return;
        }

        int middle = lower + (higher - lower) / 2;
        LogUtils.indentUp();

        sort(array, lower, middle);
        sort(array, middle + 1, higher);
        merge(array, lower, middle, higher);

        LogUtils.indentDown();
    }

    private static void merge(int array[], int lower, int middle, int higher) {
        for (int currentIndex = lower; currentIndex <= higher; currentIndex++) {
            helpArray[currentIndex] = array[currentIndex];
        }

        int i = lower, j = middle + 1;
        for (int currentIndex = lower; currentIndex <= higher; currentIndex++) {
            if (i > middle) {
                array[currentIndex] = helpArray[j];
                j++;
            } else if (j > higher) {
                array[currentIndex] = helpArray[i];
                i++;
            } else if (helpArray[j] < helpArray[i]) {
                array[currentIndex] = helpArray[j];
                j++;
            } else {
                array[currentIndex] = helpArray[i];
                i++;
            }
        }
        LogUtils.log(array, "merge", lower, higher);
    }
}
