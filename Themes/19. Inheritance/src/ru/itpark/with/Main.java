package ru.itpark.with;

public class Main {
    public static void main(String[] args) {
        SportCar bugatti = new SportCar("Veyron", 30,
                1000);

        bugatti.go(50);

        bugatti.addFuel(100);
        bugatti.addNitrousOxide(10);

        System.out.println(bugatti.getMileage());
        System.out.println(bugatti.getFuelAmount());
        System.out.println(bugatti.getNitrousOxideAmount());
    }
}
