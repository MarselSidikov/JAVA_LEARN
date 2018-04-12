package ru.itpark.abstracts.use;

public class MinMaxFinderBubbleSortImpl extends AbstractMinMaxFinder {
    public MinMaxFinderBubbleSortImpl(int[] elements) {
        super(elements);
    }

    @Override
    public void sort() {
        for (int i = elements.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }
}
