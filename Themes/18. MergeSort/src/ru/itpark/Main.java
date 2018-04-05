package ru.itpark;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int merged[] = MergeSort.sort(new int[]{2, 3, 6, 8, 9},
                new int[]{1, 2, 4, 5});

        System.out.println(Arrays.toString(merged));

    }
}
