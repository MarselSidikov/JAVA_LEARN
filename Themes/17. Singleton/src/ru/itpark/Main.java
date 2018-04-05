package ru.itpark;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//	    SecurityManager manager = new SecurityManager();
//	    manager.addName("Marsel");
//	    manager.addName("Nastya");
//	    manager.addName("Ksusha");
//	    manager.print();
//
//	    SecurityManager manager2 = new SecurityManager();
//	    manager2.addName("Artyom");
//	    manager2.addName("Egor");
//	    manager2.print();

        SecurityManager manager = SecurityManager.getManager();
        manager.addName("Marsel");
	    manager.addName("Nastya");
	    manager.addName("Ksusha");

        SecurityManager manager2 = SecurityManager.getManager();
        manager2.addName("Artyom");
	    manager2.addName("Egor");

	    manager.print();
	    manager2.print();




    }
}
