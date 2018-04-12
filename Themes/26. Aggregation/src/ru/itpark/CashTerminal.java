package ru.itpark;

public class CashTerminal {

    private int cash;
    private CheckPrinter printer;

    public CashTerminal(int cash, CheckPrinter printer) {
        this.cash = cash;
        this.printer = printer;
    }

    public void giveCash(int cash) {
        if (this.cash > cash) {
            printer.printCheck();
            this.cash -= cash;
        } else {
            System.err.println("No money");
        }
    }
}
