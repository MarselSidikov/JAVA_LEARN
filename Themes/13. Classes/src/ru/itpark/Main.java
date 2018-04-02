package ru.itpark;

public class Main {

    public static void main(String[] args) {
        Document document;

        document = new Document(3);

        Document x = document;

        Document document1 = new Document();

        document.name = "Начали за здравие";
        document.add("Привет!");
        document.add("Как дела!");

        document1.name = "Не до меня((((";
        document1.add("Пока!");
        document1.add("Потом спишемся!");

        document.print();
        document1.print();
    }
}
