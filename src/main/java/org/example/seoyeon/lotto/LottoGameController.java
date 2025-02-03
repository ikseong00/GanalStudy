package org.example.seoyeon.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGameController {
    List<Lotto> myLotto = new ArrayList<>();
    final int COST = 1000;
    final int NUMBER;
    final int BONUS;
    final int RANGE;
    Scanner scan = new Scanner(System.in);
    int[] winners = new int[5];
    double[] prize=new double[5];
    double sum=0;


    public LottoGameController(int NUMBER, int BONUS, int RANGE) {
        this.NUMBER = NUMBER;
        this.BONUS = BONUS;
        this.RANGE = RANGE;
        for (int i = 0; i < winners.length; i++) {
            winners[i] = 0;
        }
        prize[0]=2000000000;
        prize[1]=30000000;
        prize[2]=1500000;
        prize[3]=50000;
        prize[4]=5000;

    }

    public void play() {
        buyLotto();
        winningLotteryTicket();
        prizeSum();
        result();
    }

    private void buyLotto() {
        while (true) {
            Printer.println("Please enter the purchase amount (unit: " + COST + "won)");
            int money = scan.nextInt();
            scan.nextLine();
            Printer.println("");
            if (money % COST != 0) {
                Printer.errorMessage(new IllegalArgumentException("Please enter in units of" + COST + "won"));
                continue;
            }
            Printer.println("You purchased " + money / COST + " lottery tickets.");
            for (int i = 0; i < (money / COST); i++) {
                Lotto lotto = new Lotto(this.NUMBER, this.RANGE);
                myLotto.add(lotto);
                Printer.println(lotto.lottoes.toString());
            }
            break;
        }
    }

    private void winningLotteryTicket() {
        while (true) {
            Printer.println("Please enter the numbers of winning lottery ticket.");
            String[] winningInputs = scan.nextLine().split(",");
            Integer[] winningNums = new Integer[NUMBER + BONUS];
            for (int i = 0; i < NUMBER; i++) {
                winningNums[i] = Integer.parseInt(winningInputs[i]);
            }
            Printer.println("Please enter the bonus number.");
            if (BONUS == 1) {
                winningNums[NUMBER] = scan.nextInt();
            }
            for (int i=0;i<myLotto.size();i++){
                checkLottery(winningNums,myLotto.get(i));
            }
            break;
        }
    }

    private void checkLottery(Integer[] winningNums, Lotto lotto) {
        int sameNum = 0;
        boolean bonus = false;

        for (int i = 0; i < NUMBER; i++) {
            if (lotto.lottoes.contains(winningNums[i])) {
                sameNum++;
            }
        }
        if (sameNum != NUMBER){
            for(int i=0;i<BONUS;i++){
                if (lotto.lottoes.contains(winningNums[NUMBER])){
                    bonus=true;
                    break;
                }
            }
        }

            if (sameNum == NUMBER) {
                winners[0]++;
            } else if (sameNum == NUMBER - 1 && bonus) {
                winners[1]++;
            } else if (sameNum == NUMBER - 1) {
                winners[2]++;
            } else if (sameNum == NUMBER - 2) {
                winners[3]++;
            } else if (sameNum == NUMBER - 3) {
                winners[4]++;
            }
    }
    private void prizeSum(){
        for(int i=0;i<5;i++){
            sum+=winners[i]*prize[i];
        }
    }
    private void result(){
        Printer.println("");
        Printer.println("Winning Statistics");
        Printer.println("--");
        Printer.println(NUMBER-3 + "matches (5,000 won) - " + winners[4] + "tickets");
        Printer.println(NUMBER-2 + "matches (50,000 won) - " + winners[3] + "tickets");
        Printer.println(NUMBER-1 + "matches (1,500,000 won) - " + winners[2] + "tickets");
        Printer.println(NUMBER-1 + "matches & bounus ball match (30,000,000 won) - " + winners[1] + "tickets");
        Printer.println(NUMBER-3 + "matches (2,000,000,000 won) - " + winners[0] + "tickets");
        Printer.println("The total return rate is " + (sum/(myLotto.size() * COST))*100 + "%");
    }
}
