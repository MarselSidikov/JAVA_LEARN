package ru.itpark.interfaces;

public class Box extends Shape implements Scalable {
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

    @Override
    public void scale(double value) {
        this.length = this.length * value;
        this.height = this.height * value;
        this.width = this.width * value;
    }

    @Override
    public String toString() {
        return "Box{" +
                "height=" + height +
                ", length=" + length +
                ", width=" + width +
                '}';
    }
}
