package org.example.seoyeon.lotto;

public class Printer {
    static void println(String str) {
        System.out.println(str);
    }

    static void print(String str) {
        System.out.print(str);
    }

    static void enterPurchaseMoney(int cost){
        System.out.println("Please enter the purchase amount (unit: " + cost + "won)");
    }

    static void errorMessage(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    static void enterMoneyError(Exception e,int cost){
        System.out.println("[ERROR} " + "Please enter in units of" + cost + "won");
    }
}
