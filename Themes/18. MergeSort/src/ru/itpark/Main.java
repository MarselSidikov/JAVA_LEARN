package ru.itpark;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int array[] = {12, 55, -3, 6, 12, 66, 133, -10};
	    MergeSort.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }
}
