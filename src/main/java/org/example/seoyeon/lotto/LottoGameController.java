package org.example.seoyeon.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGameController {
    List<Lotto> myLotto = new ArrayList<>();
    LottoValue cost = LottoValue.COST;
    LottoValue number = LottoValue.NUMBER;
    LottoValue bonus = LottoValue.BONUS;
    LottoValue max = LottoValue.MAX;
    LottoValue min = LottoValue.MIN;

    Scanner scan = new Scanner(System.in);
    int[] winners = new int[5];
    double[] prize = new double[5];
    double sum = 0;


    public LottoGameController() {
        for (int i = 0; i < winners.length; i++) {
            winners[i] = 0;
        }
        prize[0] = 2000000000;
        prize[1] = 30000000;
        prize[2] = 1500000;
        prize[3] = 50000;
        prize[4] = 5000;

    }

    public void play() {
        buyLotto();
        winningLotteryTicket();
        prizeSum();
        result();
    }

    private void buyLotto() {
        String moneyStr;
        int money = 0;
        while (true) {
            try {
                Printer.enterPurchaseMoney(cost.value);
                money = Integer.parseInt(InputManager.moneyInput(scan.nextLine()));
                if (money % cost.value != 0) {
                    Printer.enterMoneyError(new IllegalArgumentException(), cost.value);
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                Printer.enterMoneyError(new IllegalArgumentException(), cost.value);
            }
        }
        Printer.purchasedLottery(money / cost.value);
        for (int i = 0; i < (money / cost.value); i++) {
            Lotto lotto = new Lotto(number.value, max.value);
            myLotto.add(lotto);
        }
        Printer.printLottery(myLotto);
    }

    private String enterNumber(String str) {
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

        return moneyStr;
    }

    private void winningLotteryTicket() {
        while (true) {
            String[] winningInputs;
            try {
                Printer.println("Please enter the numbers of winning lottery ticket.");
                winningInputs = scan.nextLine().split(",");
                if (winningInputs.length > number.value) {
                    throw new IllegalArgumentException("Please enter " + number.value + " numbers.");
                }
                Integer[] winningNums = new Integer[number.value + bonus.value];
                for (int i = 0; i < number.value; i++) {
                    winningNums[i] = Integer.parseInt(enterNumber(winningInputs[i]));
                    if (winningNums[i] < min.value || winningNums[i] > max.value) {
                        throw new IllegalArgumentException("Please enter the number 1 ~ " + max.value);
                    }
                }
                Printer.println("Please enter the bonus number.");
                if (bonus.getValue() == 1) {
                    winningNums[number.value] = Integer.parseInt(enterNumber(scan.nextLine()));
                    if (winningNums[number.value] < min.value || winningNums[number.value] > max.value) {
                        throw new IllegalArgumentException("Please enter the number 1 ~ " + max.value);
                    }
                }
                for (int i = 0; i < myLotto.size(); i++) {
                    checkLottery(winningNums, myLotto.get(i));
                }
                break;
            } catch (NumberFormatException e) {
                Printer.errorMessage(new IllegalArgumentException("Please enter the number 1 ~ " + max.value));
            } catch (IllegalArgumentException e) {
                Printer.errorMessage(e);
            }
        }
    }

    private void checkLottery(Integer[] winningNums, Lotto lotto) {
        int sameNum = 0;
        boolean bonusCheck = false;

        for (int i = 0; i < number.value; i++) {
            if (lotto.lottoes.contains(winningNums[i])) {
                sameNum++;
            }
        }
        if (sameNum != number.value) {
            for (int i = 0; i < bonus.value; i++) {
                if (lotto.lottoes.contains(winningNums[number.value])) {
                    bonusCheck = true;
                    break;
                }
            }
        }

        if (sameNum == number.value) {
            winners[0]++;
        } else if (sameNum == number.value - 1 && bonusCheck) {
            winners[1]++;
        } else if (sameNum == number.value - 1) {
            winners[2]++;
        } else if (sameNum == number.value - 2) {
            winners[3]++;
        } else if (sameNum == number.value - 3) {
            winners[4]++;
        }
    }

    private void prizeSum() {
        for (int i = 0; i < 5; i++) {
            sum += winners[i] * prize[i];
        }
    }

    private void result() {
        Printer.println("");
        Printer.println("Winning Statistics");
        Printer.println("--");
        Printer.println(number.value - 3 + "matches (5,000 won) - " + winners[4] + "tickets");
        Printer.println(number.value - 2 + "matches (50,000 won) - " + winners[3] + "tickets");
        Printer.println(number.value - 1 + "matches (1,500,000 won) - " + winners[2] + "tickets");
        Printer.println(number.value - 1 + "matches & bounus ball match (30,000,000 won) - " + winners[1] + "tickets");
        Printer.println(number.value - 3 + "matches (2,000,000,000 won) - " + winners[0] + "tickets");
        Printer.println("The total return rate is " + (sum / (myLotto.size() * cost.value)) * 100 + "%");
    }
}
