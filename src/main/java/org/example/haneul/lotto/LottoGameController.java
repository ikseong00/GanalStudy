package org.example.haneul.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGameController {
    Scanner scanner = new Scanner(System.in);
    Printer printer = new Printer();
    Lotto lotto = new Lotto();
    List<List> numbers = new ArrayList<>(); // 구매한 로또 리스트
    List<Integer> win=new ArrayList<>(); // 당첨번호 리스트
    int amount; //구입 금액

    public void play() {
        printer.print("구입금액을 입력해 주세요.");
        amount = scanner.nextInt()/1000;
        if (amount % 1000 != 0){
            printer.printError();
            return;
        }
        printer.print(amount+"개를 구매했습니다.");
        MakeLottery(amount);

        printer.print("당첨번호를 입력해주세요.");
        String line=scanner.nextLine();

    }

    private void MakeLottery(int amount) {
        while (numbers.size() < amount) {
            numbers.add(lotto.create());
        }
        for (List list : numbers) {
            printer.printLotto(list);
        }
    }

    private void check(){

    }

}
