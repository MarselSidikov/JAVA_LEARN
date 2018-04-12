package ru.itpark;

public class CashTerminal extends CheckPrinter {
    private int cash;

    public CashTerminal(int cash) {
        this.cash = cash;
    }

    public void giveCash(int cash) {
        if (this.cash > cash) {
            printCheck();
            this.cash -= cash;
        } else {
            System.err.println("No money");
        }
    }
}
