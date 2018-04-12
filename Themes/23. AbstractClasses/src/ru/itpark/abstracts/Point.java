package ru.itpark.abstracts;

public class Point extends Shape {
    public Point(double x, double y, double z) {
        super(x, y, z);
    }

    @Override
    public double calcVolume() {
        return 0;
    }
}
