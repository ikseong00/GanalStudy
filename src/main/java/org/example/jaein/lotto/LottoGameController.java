package org.example.jaein.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.*;

public class LottoGameController {
    static Printer printer=new Printer();
    static Scanner scanner=new Scanner(System.in);

    public static void lottoGame() {

        //1. 로또 구입
        int money = 0;
        int lottoAmount = 0;
        ArrayList<Lotto> lottos=new ArrayList<>();

        while (true) {
            try {
                printer.printStr("구입금액을 입력해 주세요.");
                money = scanner.nextInt();
                scanner.nextLine();
                if (money % 1000 != 0) { //예외1
                    throw new IllegalArgumentException("[Error] 구입 금액은 1,000원 단위여야 합니다.");
                }
                if (money < 0) { //예외2
                    throw new IllegalArgumentException("[Error] 구입 금액을 음수로 입력하지 마세요.");
                }
                lottoAmount = money / 1000;
                break;
            } catch (IllegalArgumentException e) {
                printer.printStr("e.getMessage()");
            }
        }

        //2. 로또 개수, 번호 출력
        printer.printLottoAmount(lottoAmount);
        for (int i = 1; i <= lottoAmount; i++) {
            Lotto lotto = new Lotto();
            lotto.makeLotto();
            lottos.add(lotto);
            printer.printLottoList(lotto);
        }

        //3. 당첨 번호 입력
        List<Integer> winNums = new ArrayList<>();
        while (true) {
            try {
                printer.printStr("당첨 번호를 입력해 주세요.");
                String[] winNum = scanner.nextLine().split(",");
                if (winNum.length != 6) { //예외3
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 6개를 입력해야 합니다.");
                }
                winNums.clear();
                for (String nums : winNum) {
                    int num = Integer.parseInt(nums.trim());
                    if (num < 1 || num > 45 || winNums.contains(num)) { //예외4
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 하며 중복되면 안됩니다.");
                    }
                    winNums.add(num);
                }
                break;
            } catch(IllegalArgumentException e){
                printer.printStr("e.getMessage()");
            }
        }

        //4. 보너스 번호 입력
        int bonusNum = 0;
        while (true) {  // 잘못 입력되었을 경우 계속 반복
            try {
                printer.printStr("보너스 번호를 입력해 주세요.");
                bonusNum = scanner.nextInt();
                if (bonusNum < 1 || bonusNum > 45 || winNums.contains(bonusNum)) { //예외5
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 하며 당첨 번호와 중복되면 안됩니다.");
                }
                break;  // 정상적으로 입력되었으면 반복 종료
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        //5. 당첨 통계
        Map<String, Integer> result = new HashMap<>();
        result.put("3", 0);
        result.put("4", 0);
        result.put("5", 0);
        result.put("5+보너스", 0);
        result.put("6", 0);

        for (Lotto lotto:lottos) {
            int count=0;
            int bonusCount=0;
            for (int num:lotto.lotto) {
                if (winNums.contains(num)) {
                    count++;
                }
            }
            if (winNums.contains(bonusNum)&&lotto.lotto.contains(bonusNum)) {
                bonusCount=1;
            }
            if (count == 6) result.put("6", result.get("6") + 1);
            else if (count == 5 && bonusCount==1) result.put("5+보너스", result.get("5+보너스") + 1);
            else if (count == 5&&bonusCount!=1) result.put("5", result.get("5") + 1);
            else if (count == 4) result.put("4", result.get("4") + 1);
            else if (count == 3) result.put("3", result.get("3") + 1);
        }

        //6. 당첨 통계 결과 출력
        double getMoney=result.get("3")*5000+result.get("4")*50000+result.get("5")*1500000+result.get("5+보너스")*30000000+result.get("6")*2000000000;
        double profit=getMoney/money*100;
        printer.printLottoResult(result, profit);
    }
}