package ru.itpark;

import java.time.LocalDateTime;

public class BadCheckPrinterImpl implements CheckPrinter {
    public void printCheck() {
        killClient();
        System.out.println(LocalDateTime.now() + " money was given out");
    }

    public void killClient() {
        System.err.println("Hahah client is dead");
    }
}
