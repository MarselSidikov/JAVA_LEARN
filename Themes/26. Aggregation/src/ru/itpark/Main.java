package ru.itpark;

public class Main {

    public static void main(String[] args) {
        CheckPrinter printer = new GoodCheckPrinterImpl();
        CashTerminal terminal = new CashTerminal(50, printer);
        terminal.giveCash(40);

    }
}
