package ru.itpark;

public class GoodCheckPrinterImpl implements CheckPrinter {
    @Override
    public void printCheck() {
        System.out.println("Может  еще денег подкинуть?");
    }
}
