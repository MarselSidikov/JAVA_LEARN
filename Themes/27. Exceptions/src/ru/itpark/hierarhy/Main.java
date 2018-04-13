package ru.itpark.hierarhy;

public class Main {
    public static void stackOverflow() {
        stackOverflow();
    }

    public static void outOfMemory() {
        String[] strings = new String[Integer.MAX_VALUE];
    }

    public static void nullPointer() {
        String s = null;
        s.length();
    }

    public static void outOfBounds() {
        int a[] = new int[5];
        System.out.println(a[5]);
    }

    public static void threadDeath() {
        throw new ThreadDeath();
    }

    public static void internalError() {
        throw new InternalError();
    }

    public static void main(String[] args) {
        try {
            // outOfMemory();
            // stackOverflow();
            // internalError();
            //threadDeath();
            outOfBounds();
        } catch (StackOverflowError e) {
            System.out.println("Я на stackOverflow");
        } catch (OutOfMemoryError e) {
            System.out.println("Я на outOfMemory");
        } catch (VirtualMachineError e) {
            System.out.println("Я на чем-то из VirtualMachine");
        } catch (Error e) {
            System.out.println("Какой-то эррор ((((");
        } catch (Exception e) {
            System.out.println("Я на эксепшн");
        }
    }
}
