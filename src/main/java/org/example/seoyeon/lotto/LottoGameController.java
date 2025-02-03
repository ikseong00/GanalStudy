package org.example.seoyeon.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGameController {
    List<Lotto> myLotto = new ArrayList<>();
    final int COST = 1000;

    public void play() {
        buyLotto();
    }

    private void buyLotto() {
        while (true) {
            Printer.println("구입 금액을 입력하시오. (단위: " + COST + "원)");
            Scanner scan = new Scanner(System.in);
            int money = scan.nextInt();
            if (money % COST != 0) {
                Printer.errorMessage(new IllegalArgumentException("[ERROR] " + COST + "원 단위로 입력하시오."));
                continue;
            }
            break;
        }
    }
}
