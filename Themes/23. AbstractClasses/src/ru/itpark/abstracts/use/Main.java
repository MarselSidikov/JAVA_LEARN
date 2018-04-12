package ru.itpark.abstracts.use;

public class Main {
    public static void main(String[] args) {
        int elements[] = {34, 12, 111, -10, 22, 5};
        AbstractMinMaxFinder finder = new MinMaxFinderMergeSortImpl(elements);
        System.out.println(finder.findMax());
        System.out.println(finder.findMin());
    }
}
