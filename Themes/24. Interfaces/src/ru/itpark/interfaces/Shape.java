package ru.itpark.interfaces;

public abstract class Shape implements Moveable {
    private double x;
    private double y;
    private double z;

    public Shape(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public abstract double calcVolume();

    @Override
    public void move(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
