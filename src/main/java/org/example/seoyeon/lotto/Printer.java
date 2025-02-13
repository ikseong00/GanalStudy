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

    static void enterWinningLotteryPlz() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    static void enterBonusPlz() {
        System.out.println("Please enter the bonus number.");
    }

    static void errorMessage(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    static void enterMoneyError(Exception e, int cost) {
        System.out.println("[ERROR} " + "Please enter in units of" + cost + "won");
    }

    public static void result(LottoGameController c) {
        Printer.println("");
        Printer.println("Winning Statistics");
        Printer.println("--");
        Printer.println(c.number.value - 3 + "matches (" + PRIZE.FIFTH_PRIZE.prize +"won) - " + c.winners[4] + "tickets");
        Printer.println(c.number.value - 2 + "matches (" +PRIZE.FORTH_PRIZE.prize + "won) - " + c.winners[3] + "tickets");
        Printer.println(c.number.value - 1 + "matches (" +PRIZE.THIRD_PRIZE.prize +"won) - " + c.winners[2] + "tickets");
        Printer.println(c.number.value - 1 + "matches & bounus ball match (" + PRIZE.SECOND_PRIZE.prize +"won) - " + c.winners[1] + "tickets");
        Printer.println(c.number.value  + "matches (" + PRIZE.FIRST_PRIZE.prize + "won) - " + c.winners[0] + "tickets");
        Printer.println("The total return rate is " + (c.sum / c.money) * 100 + "%");
    }
}
