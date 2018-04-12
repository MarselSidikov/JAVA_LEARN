package ru.itpark;

public class Main {

    public static void main(String[] args) {
        CashTerminal terminal = new CashTerminal(50);
        terminal.giveCash(20);
        terminal.killClient();
    }
}
