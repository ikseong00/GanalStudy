package org.example.haneul.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LottoGameController {
    Scanner scanner = new Scanner(System.in);
    Printer printer = new Printer();
    List<Lotto> numbers = new ArrayList<>(); // 구매한 로또 리스트
    List<Integer> win = new ArrayList<>(); // 당첨번호 리스트
    List<Integer> results = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));// 결과 리스트
    int amount, bonus; //구매 개수와 보너스 번호
    int[] prize = new int[5];


    public void play() {
        prize[4] = 5000;
        prize[3] = 50000;
        prize[2] = 1500000;
        prize[1] = 30000000;
        prize[0] = 2000000000;

        try{
            printer.printStart();
            int price = scanner.nextInt();
            amount = price / 1000;

            if (price % 1000 != 0) {
                throw new AmountException("로또는 천원 단위로 구입할 수 있습니다.");
            }

            printer.printAmount(amount);
            MakeLottery(amount);

            printer.printInput();
            scanner.nextLine();

            String line = scanner.nextLine();
            String[] number = line.split(",");
            for (String s : number) {
                win.add(Integer.parseInt(s));
            }

            if (win.size() != 6){
                throw new LottoNumberException("로또 번호는 6개 입력해야합니다.");
            }

            printer.printBonus();
            bonus = scanner.nextInt();

            if (win.contains(bonus)) {
                throw new BonusException("보너스 번호는 로또 번호와 중복되면 안됩니다.");
            }

            check();

            totalResult();
        }catch (AmountException | LottoNumberException | BonusException e){
            printer.printError(e);
        }catch (NumberFormatException e){
            printer.printError();
        }

    }


    private void MakeLottery(int amount) {
        while (numbers.size() < amount) {
            numbers.add(new Lotto());
        }

        for (Lotto list : numbers) {
            printer.printLotto(list);
        }
    }

    private void check() {
        for (Lotto number : numbers) {
            checkLotto(number);
        }
    }

    private void checkLotto(Lotto lotto) {
        int count = 0;
        boolean b = false;
        for (int i : lotto.lottoes) {
            if (win.contains(i)) {
                count++;
            }
        }
        if (lotto.lottoes.contains(bonus))
            b = true;

        if (count == 6) {
            results.set(0, results.get(0) + 1);
        } else if (count == 5) {
            if (b)
                results.set(1, results.get(1) + 1);
            else results.set(2, results.get(2) + 1);
        } else if (count == 4) {
            results.set(3, results.get(3) + 1);
        } else if (count == 3) {
            results.set(4, results.get(4) + 1);
        }

    }

    private void totalResult() {
        printer.printResult();
        printer.printResult(3, prize[4], results.get(4), false);
        printer.printResult(4, prize[3], results.get(3), false);
        printer.printResult(5, prize[2], results.get(2), false);
        printer.printResult(5, prize[1], results.get(1), true);
        printer.printResult(6, prize[0], results.get(0), false);

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += prize[i] * results.get(i);
        }
        double res = (double) sum / amount * 100;
        String formRes = String.format("%.2f", res);
        printer.print("총 수익률은 " + formRes + "%입니다.");
    }

}
