package ru.itpark.abstracts;

public class Sphere extends Shape {
    private double radius;


    public Sphere(double x, double y, double z, double radius) {
        super(x, y, z);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calcVolume() {
        return (4.0 / 3) * Math.PI
                * radius * radius * radius;
    }
}
