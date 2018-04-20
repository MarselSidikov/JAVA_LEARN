package ru.itpark;

public class MainArrayList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Marsel");
        list.add("Shamil");
        list.add("Roman");
        list.add("Adel");
        list.add("Rustem");
        list.add("Sergey");
        list.add("Damir");
        list.add("Nastya");
        list.add("Egor");
        list.add("Ilya");
        list.add("Marsel");
        list.add("Nailya");

        list.delete(0);
        System.out.println(list.delete("Marsel"));
        System.out.println(list.get(0));
        System.out.println(list.size());
        System.out.println(list.contains("Roman"));
        System.out.println(list.contains("Ksusha"));
        System.out.println(list.get(2));
       // System.out.println(list.get(10));
    }
}
