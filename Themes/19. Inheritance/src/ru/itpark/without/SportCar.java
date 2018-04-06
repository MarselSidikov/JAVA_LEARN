package ru.itpark.without;

public class SportCar {
    private String model;
    private int mileage;

    private double fuelConsumption;
    private double fuelAmount;

    private double nitrousOxideConsumption;
    private double nitrousOxideAmount;

    public SportCar(String model, double fuelConsumption, double nitrousOxideConsumption) {
        this.model = model;
        this.nitrousOxideConsumption = nitrousOxideConsumption;
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
        this.nitrousOxideAmount = this.nitrousOxideAmount - km * (this.nitrousOxideAmount / 100);
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getNitrousOxideAmount() {
        return nitrousOxideAmount;
    }

    public void addNitrousOxide(double nitrousOxideAmount) {
        this.nitrousOxideAmount += nitrousOxideAmount;
    }

    public double getNitrousOxideConsumption() {
        return nitrousOxideConsumption;
    }
}
