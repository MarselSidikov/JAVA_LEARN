package ru.itpark;

import java.time.LocalDateTime;

public class CheckPrinter {
    public void printCheck() {
        killClient();
        System.out.println(LocalDateTime.now() + " money was given out");
    }

    public void killClient() {
        System.err.println("Hahah client is dead");
    }
}
