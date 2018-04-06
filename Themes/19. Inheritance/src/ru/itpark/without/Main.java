package ru.itpark.without;

public class Main {

    public static void main(String[] args) {
	    Car kia = new Car("RIO", 7);
	    kia.addFuel(45);
	    kia.go(50);

        System.out.println(kia.getMileage());
        System.out.println(kia.getFuelAmount());

        System.out.println("-------------");
        SportCar bugatti = new SportCar("Veyron", 30, 1000);
        bugatti.addNitrousOxide(10);
        bugatti.addFuel(100);
        bugatti.go(50);
        System.out.println(bugatti.getMileage());
        System.out.println(bugatti.getFuelAmount());
        System.out.println(bugatti.getNitrousOxideAmount());
    }
}
