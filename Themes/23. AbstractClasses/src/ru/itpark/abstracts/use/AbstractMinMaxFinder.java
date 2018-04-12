package ru.itpark.abstracts.use;

public abstract class AbstractMinMaxFinder {
    protected int elements[];
    private boolean isNotSorted;

    public AbstractMinMaxFinder(int[] elements) {
        this.elements = elements;
        this.isNotSorted = true;
    }

    public int findMin() {
        if (isNotSorted) {
            sort();
            isNotSorted = false;
            return elements[0];
        } else {
            return elements[0];
        }
    }

    public int findMax() {
        if (isNotSorted) {
            sort();
            isNotSorted = false;
            return elements[elements.length - 1];
        } else {
            return elements[elements.length - 1];
        }
    }

    public abstract void sort();
}
