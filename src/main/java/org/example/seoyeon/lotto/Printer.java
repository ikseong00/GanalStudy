package org.example.seoyeon.lotto;

public class Printer {
    static void println(String str) {
        System.out.println(str);
    }

    static void print(String str) {
        System.out.print(str);
    }

    static void errorMessage(Exception e) {
        System.out.println("[ERROR] " +e.getMessage());
    }
}
