package ru.itpark.abstracts.use;

public class MinMaxFinderMergeSortImpl extends AbstractMinMaxFinder {

    private int helpArray[];

    public MinMaxFinderMergeSortImpl(int[] elements) {
        super(elements);
        helpArray = new int[elements.length];
    }

    @Override
    public void sort() {
        sort(elements, 0, elements.length - 1);
    }

    public void sort(int array[], int lower, int higher) {

        if (higher <= lower) {
            return;
        }

        int middle = lower + (higher - lower) / 2;

        sort(array, lower, middle);
        sort(array, middle + 1, higher);
        merge(array, lower, middle, higher);

    }

    private void merge(int array[], int lower, int middle, int higher) {
        System.arraycopy(array, lower, helpArray, lower, higher + 1 - lower);

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
    }
}
