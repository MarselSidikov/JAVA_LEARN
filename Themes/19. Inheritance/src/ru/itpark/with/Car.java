package ru.itpark.with;

public class Car {
    private String model;
    protected int mileage;
    protected double fuelConsumption;
    protected double fuelAmount;

    public Car(String model, double fuelConsumption) {
        this.model = model;
        this.mileage = 0;
        this.fuelConsumption = fuelConsumption;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void addFuel(double fuel) {
        this.fuelAmount += fuel;
    }

    public void go(int km) {
        this.mileage = mileage + km;
        this.fuelAmount = this.fuelAmount - km * (this.fuelConsumption / 100);
    }

    public double getFuelAmount() {
        return fuelAmount;
    }
}
