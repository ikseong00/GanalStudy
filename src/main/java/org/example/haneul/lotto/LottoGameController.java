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
    int amount, bonus; //구매 개수와 보너스 번호
    int[] result=new int[5];

    public void play() {
        printer.print("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();
        amount = price/1000;

        if (price % 1000 != 0){
            printer.printError();
            return;
        }
        printer.print(amount+"개를 구매했습니다.");
        MakeLottery(amount);

        printer.print("당첨번호를 입력해주세요.");
        String line=scanner.nextLine();
        String[] number = line.split(",");
        for (String s : number) {
            win.add(Integer.parseInt(s));
        }

        printer.print("보너스 번호를 입력해주세요.");
        bonus = scanner.nextInt();
        if (win.contains(bonus)) {
            printer.printError();
            return;
        }

        check();

        printer.print("당첨 통계\n---\n");

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
        for (List number : numbers) {
            checkLotto(number);
        }
    }

    private void checkLotto(List<Integer> list) {
        int count=0;
        boolean b=false;
        for (int i:list){
            if (win.contains(i)){
                count++;
            }
        }
        if (list.contains(bonus))
            b=true;

    }

}
