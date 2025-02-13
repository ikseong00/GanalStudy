package org.example.seoyeon.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class InputManager {
    static Scanner scan = new Scanner(System.in);

    static int moneyInput(String str) {
        String moneyStr = str.replaceAll("[ ,]|won|원", "");
        if (moneyStr.indexOf("십") == 0) {
            moneyStr = moneyStr.replace("십", "10");
        } else {
            moneyStr = moneyStr.replace("십", "0");
        }
        if (moneyStr.indexOf("백") == 0) {
            moneyStr = moneyStr.replace("백", "100");
        } else {
            moneyStr = moneyStr.replace("백", "00");
        }
        if (moneyStr.indexOf("천") == 0) {
            moneyStr = moneyStr.replace("천", "1000");
        } else {
            moneyStr = moneyStr.replace("천", "000");
        }
        if (moneyStr.indexOf("만") == 0) {
            moneyStr = moneyStr.replace("만", "10000");
        } else {
            moneyStr = moneyStr.replace("만", "0000");
        }
        moneyStr = moneyStr.replace("일", "1");
        moneyStr = moneyStr.replace("이", "2");
        moneyStr = moneyStr.replace("삼", "3");
        moneyStr = moneyStr.replace("사", "4");
        moneyStr = moneyStr.replace("오", "5");
        moneyStr = moneyStr.replace("육", "6");
        moneyStr = moneyStr.replace("칠", "7");
        moneyStr = moneyStr.replace("팔", "8");
        moneyStr = moneyStr.replace("구", "9");

        int money = Integer.parseInt(moneyStr);

        if (money % LottoValue.COST.value != 0) {
            throw new IllegalArgumentException();
        }

        return money;
    }

    static double doubleInput(String str) {
        String doubleStr = str.replace(",", "");

        double d = Double.parseDouble(doubleStr);
        return d;
    }

    static Lotto lotteryInput(String str) {
        str = str.replaceAll(" ", "");
        String[] numbers = str.split(",");
        if (numbers.length > LottoValue.NUMBER.value) {
            throw new IllegalArgumentException("Please enter " + LottoValue.NUMBER.value + " numbers.");
        }
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < LottoValue.NUMBER.value; i++) {
            int num = Integer.parseInt(numbers[i]);
            if (lotto.contains(num)) {
                throw new IllegalArgumentException();
            }
            if (num < LottoValue.MIN.value || num > LottoValue.MAX.value) {
                throw new IllegalArgumentException("Please enter the number 1 ~ " + LottoValue.MAX.value);
            }
            lotto.add(num);
        }
        Lotto winningLottery = new Lotto(lotto);
        return winningLottery;
    }

    static List<Integer> bonusInput(List<Integer> bonus, Lotto winningLotto) {
        Printer.enterBonusPlz();
        while (bonus.size() < LottoValue.BONUS.value) {
            int num = Integer.parseInt(scan.nextLine());
            if (winningLotto.lottoes.contains(num)) {
                throw new IllegalArgumentException();
            }
            if (num < LottoValue.MIN.value || num > LottoValue.MAX.value) {
                throw new IllegalArgumentException("Please enter the number 1 ~ " + LottoValue.MAX.value);
            }
            bonus.add(num);
        }
        return bonus;
    }
}
