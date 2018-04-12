package ru.itpark.abstracts;

public class Main {

    public static void main(String[] args) {
        Sphere s1 = new Sphere(1, 1, 1, 10);
        Sphere s2 = new Sphere(5, 5, 5, 3);
        Sphere s3 = new Sphere(10, 10, 10, 2);

        Box b1 = new Box(1, 1, 1, 2, 2, 2);
        Box b2 = new Box(5, 5, 5, 3, 3, 3);
        Box b3 = new Box(10, 10, 10, 4, 4, 4);

        Shape shapes[] = {s1, b1, s2, b2, s3, b3};

        for (Shape shape : shapes) {
            System.out.println(shape.calcVolume());
        }

        // Shape shape = new Shape(1,1,1);
        Shape sphereAsShape = s1;

    }
}
