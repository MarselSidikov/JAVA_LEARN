package ru.itpark.methods;

public class RationalNumber {

    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void show() {
        System.out.println(numerator + "/" + denominator);
    }

//    public void multiply(RationalNumber that) {
//        this.numerator = this.numerator * that.numerator;
//        this.denominator = this.denominator * that.denominator;
//    }

//    public RationalNumber multiply(RationalNumber  that) {
//        return new RationalNumber(this.numerator * that.numerator,
//                this.denominator * that.denominator);
//    }

    public static RationalNumber multiply(RationalNumber x, RationalNumber y) {
        return new RationalNumber(x.numerator * y.numerator, x.denominator * y.denominator);
    }

}
