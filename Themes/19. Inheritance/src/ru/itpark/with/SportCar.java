package ru.itpark.with;

public class SportCar extends Car {
    private double nitrousOxideConsumption;
    private double nitrousOxideAmount;

    public SportCar(String model, double fuelConsumption,
                    double nitrousOxideConsumption) {
        super(model, fuelConsumption);
        this.nitrousOxideConsumption = nitrousOxideConsumption;
    }

    public double getNitrousOxideConsumption() {
        return nitrousOxideConsumption;
    }

    public double getNitrousOxideAmount() {
        return nitrousOxideAmount;
    }

    public void addNitrousOxide(double nitrousOxideAmount) {
        this.nitrousOxideAmount += nitrousOxideAmount;
    }

//    public void go(int km) {
//        this.mileage = mileage + km;
//        this.fuelAmount = this.fuelAmount - km * (this.fuelConsumption / 100);
//        this.nitrousOxideAmount = this.nitrousOxideAmount - km * (this.nitrousOxideAmount / 100);
//    }

    public void go(int km) {
        super.go(km);
        this.nitrousOxideAmount = this.nitrousOxideAmount - km * (this.nitrousOxideAmount / 100);
    }
}
