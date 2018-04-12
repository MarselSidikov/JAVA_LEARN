package ru.itpark.interfaces;

public class Sphere extends Shape implements Scalable {
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

    @Override
    public void scale(double value) {
        this.radius = this.radius * value;
    }

    @Override
    public String toString() {
        return "Sphere{" +
                "radius=" + radius +
                '}';
    }
}
