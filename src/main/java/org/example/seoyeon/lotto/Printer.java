package org.example.seoyeon.lotto;

import java.util.List;

public class Printer {
    static void println(String str) {
        System.out.println(str);
    }

    static void print(String str) {
        System.out.print(str);
    }

    static void enterPurchaseMoney(int cost) {
        System.out.println("Please enter the purchase amount (unit: " + cost + "won)");
    }

    static void purchasedLottery(int i) {
        System.out.println("You purchased " + i + " lottery tickets.");
        System.out.println();
    }

    static void printLottery(List<Lotto> lottery) {
        for (int i = 0; i < lottery.size(); i++) {
            System.out.println(lottery.get(i).lottoes);
        }

    }

    static void errorMessage(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    static void enterMoneyError(Exception e, int cost) {
        System.out.println("[ERROR} " + "Please enter in units of" + cost + "won");
    }
}
