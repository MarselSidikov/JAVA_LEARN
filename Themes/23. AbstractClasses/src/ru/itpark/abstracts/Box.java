package ru.itpark.abstracts;

public class Box extends Shape {
    private double height;
    private double length;
    private double width;

    public Box(double x, double y, double z, double height, double length, double width) {
        super(x, y, z);
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double calcVolume() {
        return this.length * this.height * this.width;
    }
}
