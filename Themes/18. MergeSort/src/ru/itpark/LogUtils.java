package ru.itpark;

/**
 * Created by User on 01.04.2017.
 */
public class LogUtils {
    public static void log(int array[], String message, int lower, int higher) {

        int i = 0;

        while (i < lower) {
            System.out.print(array[i] + " ");
            i++;
        }

        System.out.print("[");

        while (i < higher) {
            System.out.print(array[i] + " ");
            i++;
        }

        System.out.print(array[i]);
        i++;

        System.out.print("] ");

        while (i < array.length) {
            System.out.print(array[i] + " ");
            i++;
        }

        for (i = 0; i <= indent; i++) {
            System.out.print("  ");
        }

        System.out.println(message +"(" + lower + "," + higher + ")");
    }

    private static int indent;

    static {
        indent = 0;
    }

    public static void indentUp() {
        indent++;
    }

    public static void indentDown() {
        indent--;
    }
}