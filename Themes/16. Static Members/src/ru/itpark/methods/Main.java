package ru.itpark.methods;

public class Main {

    public static void main(String[] args) {
	    RationalNumber a =
                new RationalNumber(7, 5);

	    RationalNumber b =
                new RationalNumber(6, 8);

	    a.show();
	    b.show();

	    // RationalNumber c = a * b;
        //RationalNumber c = a.multiply(b);

        RationalNumber c = RationalNumber.multiply(a, b);
        a.show();
        c.show();
    }
}
