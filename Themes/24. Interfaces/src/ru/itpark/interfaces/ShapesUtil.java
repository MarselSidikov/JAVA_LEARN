package ru.itpark.interfaces;

public class ShapesUtil {
    public static void scaleAll(double value, Scalable scalables[]) {
        for (Scalable scalable : scalables) {
            scalable.scale(value);
        }
    }
}
