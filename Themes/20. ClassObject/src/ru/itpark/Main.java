package ru.itpark;

public class Main {

    public static void assertEquals(Object a, Object b) {
        if (a.equals(b)) {
            System.err.println("Is equals");
        } else {
            System.err.println("Not equals");
        }
    }

    public static void main(String[] args) {
	      Human human = new Human("Marsel", 24);
        System.out.println(human);

        Human adel = new Human("Adel", 25);
        Human adel2 = new Human("Adel", 25);
        System.out.println(adel == adel2);
        System.out.println(adel.equals(adel2));

        assertEquals(adel, adel2);

        System.out.println(adel.equals("Adel"));
//        adel2 = adel;
//        System.out.println(adel == adel2);
    }
}
