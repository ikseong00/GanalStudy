package org.example.seoyeon.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGameController {
    List<Lotto> myLotto = new ArrayList<>(); // 사용자가 구매한 로또들
    int money = 0; // 구매 금액
    LottoValue cost = LottoValue.COST; // 로또 가격
    LottoValue number = LottoValue.NUMBER; // 한 장의 로또 속 숫자의 개수
    LottoValue bonus = LottoValue.BONUS; // 보너스 넘버의 개수
    LottoValue max = LottoValue.MAX; // 로또 번호의 최대치
    LottoValue min = LottoValue.MIN; // 로또 번호의 최소치
    Lotto winningLottery;
    List<Integer> bonusNumbers = new ArrayList<>();

    Scanner scan = new Scanner(System.in);
    int[] winners = new int[LottoValue.WINNERS.value];
    PRIZE[] prize = PRIZE.values();
    double sum = 0;


    public LottoGameController() {
        for (int i = 0; i < winners.length; i++) {
            winners[i] = 0;
        }
    }

    public void play() {
        buyLotto();
        setWinningLottery();
        setBonusNumbers();
        checkLottery(myLotto);
        prizeSum();
        Printer.result(this);
    }

    private void buyLotto() {
        while (true) {
            try {
                Printer.enterPurchaseMoney(cost.value);
                money = InputManager.moneyInput(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                Printer.enterMoneyError(new IllegalArgumentException(), cost.value);
            } catch (IllegalArgumentException e) {
                Printer.enterMoneyError(e, cost.value);
            }
        }
        Printer.purchasedLottery(money / cost.value);
        for (int i = 0; i < (money / cost.value); i++) {
            Lotto lotto = new Lotto();
            myLotto.add(lotto);
        }
        Printer.printLottery(myLotto);
    }


    private void setWinningLottery() {
        while (true) {
            try {
                Printer.enterWinningLotteryPlz();
                winningLottery = InputManager.lotteryInput(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                Printer.errorMessage(e);
            } catch (IllegalArgumentException e) {
                Printer.errorMessage(e);
            }
        }
    }

    private void setBonusNumbers() {
        while (true) {
            try {
                bonusNumbers = InputManager.bonusInput(this.bonusNumbers, winningLottery);
                break;
            } catch (NumberFormatException e) {
                Printer.errorMessage(e);
            } catch (IllegalArgumentException e) {
                Printer.errorMessage(e);
            }
        }
    }

    private void checkLottery(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            checkLottery(lotto);
        }
    }

    private void checkLottery(Lotto lotto) {
        int sameNum = 0;
        boolean bonusCheck = false;

        for (int i = 0; i < number.value; i++) {
            if (lotto.lottoes.contains(winningLottery.lottoes.get(i))) {
                sameNum++;
            }
        }
        if (sameNum != number.value) {
            for (int i = 0; i < bonus.value; i++) {
                if (lotto.lottoes.contains(bonusNumbers.get(i))) {
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
        for (int i = 0; i < prize.length; i++) {
            sum += winners[i] * InputManager.doubleInput(prize[i].prize);
        }
    }

}
