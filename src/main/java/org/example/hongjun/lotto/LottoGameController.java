package org.example.hongjun.lotto;

import java.util.*;

public class LottoGameController {
    static Scanner scanner = new Scanner(System.in);
    static int[] prizeMoney = {5000, 50000, 1500000, 30000000, 2000000000}; // 당첨금

    public static void play() {
        int money = 0; // 구입 금액

        while (true) {
            try {
                try {
                    Printer.printMoneyStr();
                    money = Integer.parseInt(scanner.nextLine());
                    if ((money % 1000 != 0) || (money <= 0)) { // 음수거나 1000원 단위가 아니면
                        throw new IllegalArgumentException("잘못된 금액입니다.");
                    }
                    break;
                } catch (NumberFormatException e) { // 문자열, 실수, 공백, 엔터 등 입력 시
                    throw new IllegalArgumentException("정수를 입력하세요.");
                }
            } catch (IllegalArgumentException e) {
                Printer.printError(e.getMessage());
            }
        }

        int lottoCount = money / 1000;

        Printer.printLottoCount(lottoCount);

        // 로또 lottoCount개 생성
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }

        Printer.printLotto(lottos);

        Printer.printLine();

        List<Integer> winNumber = new ArrayList<>(); // 당첨 번호
        while (true) {
            try {
                try {
                    Printer.printWinNumberStr();
                    String[] splitArr = scanner.nextLine().split(","); // , 기준 나누기

                    // 당첨 번호 int로 저장
                    for (String number : splitArr) {
                        winNumber.add(Integer.parseInt(number));
                    }

                    for (int number : winNumber) {
                        if ((number < 1) || (number > 45)) { // 1~45 사이 아니면
                            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                        }
                    }
                    if (winNumber.size() != 6) { // 6개 아니면
                        throw new IllegalArgumentException("6개의 번호를 입력해야 합니다.");
                    }
                    if (isDuplication(winNumber)) { // 중복 번호 있으면
                        throw new IllegalArgumentException("중복된 번호가 있습니다.");
                    }
                    break;
                } catch (NumberFormatException e) { // 문자열, 실수, 공백, 엔터 등 입력
                    throw new IllegalArgumentException("정수를 입력하세요.");
                }
            } catch (IllegalArgumentException e) {
                Printer.printError(e.getMessage());
                winNumber.clear();
            }
        }
        Printer.printLine();

        int bonusNumber = 0; // 보너스 번호
        while (true) {
            try {
                try {
                    Printer.printBonusNumberStr();
                    bonusNumber = Integer.parseInt(scanner.nextLine());

                    if ((bonusNumber < 1) || (bonusNumber > 45)) { // 1~45 사이 아니면
                        throw new LottoRangeException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                    if (winNumber.contains(bonusNumber)) { // 당첨 번호와 중복
                        throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
                    }
                    break;
                } catch (NumberFormatException e) { // 문자열, 실수, 공백, 엔터 등 입력 시
                    throw new IllegalArgumentException("정수를 입력하세요.");
                } catch (LottoRangeException e) {
                    Printer.printError(e.getMessage());
                }
            } catch (IllegalArgumentException e) {
                Printer.printError(e.getMessage());
            }
        }

        int[] rank = checkWin(lottos, winNumber, bonusNumber);

        Printer.printResult(addComma(prizeMoney), rank);

        Printer.printProfitRate(getProfitRate(prizeMoney, rank, money));

    }

    // 당첨 확인
    private static int[] checkWin(List<Lotto> lottos, List<Integer> winNumber, int bonusNumber) {
        int[] rank = new int[5]; // 등수 별 당첨 개수

        for (Lotto lotto : lottos) { // 모든 로또 확인
            int count = 0; // 일치하는 번호 수
            boolean bonus = false; // 보너스 번호 일치 여부
            for (int number : lotto.winNumber) {
                if (winNumber.contains(number)) {
                    count++;
                } else if (bonusNumber == number) {
                    bonus = true;
                }
            }

            if (count == 6) {
                rank[4]++;
            } else if (count == 5) {
                if (bonus) {
                    rank[3]++;
                } else {
                    rank[2]++;
                }
            } else if (count == 4) {
                rank[1]++;
            } else if (count == 3) {
                rank[0]++;
            }
        }

        return rank;
    }

    // 당첨금에 , 추가해서 String 배열로 변환
    private static String[] addComma(int[] prizeMoney) {
        String[] result = new String[prizeMoney.length];
        for (int i = 0; i < prizeMoney.length; i++) {
            // 3글자마다 , 추가
            String strMoney = String.valueOf(prizeMoney[i]);
            String commaMoney = "";
            int index = 0;
            for (int j = 0; j < (strMoney.length() - 1) / 3 + 1; j++) {
                if (j == (strMoney.length() - 1) / 3) { // 마지막 반복이면
                    commaMoney = strMoney.substring(0, strMoney.length() - index) + commaMoney;
                } else {
                    commaMoney = "," + strMoney.substring(strMoney.length() - index - 3, strMoney.length() - index) + commaMoney;
                }
                index += 3;
            }
            result[i] = commaMoney;
        }

        return result;
    }

    // 수익률 계산
    private static double getProfitRate(int[] prizeMoney, int[] rank, int money) {
        int total = 0;
        for (int i = 0; i < prizeMoney.length; i++) {
            total += prizeMoney[i] * rank[i];
        }
        double profitRate = 100.0 * total / money;
        return Math.round(profitRate * 10) / 10.0;
    }

    // 중복 번호 확인
    private static boolean isDuplication(List<Integer> winNumber) {
        Set<Integer> set = new HashSet<>();
        for (int number : winNumber) {
            set.add(number);
        }
        return set.size() != winNumber.size();
    }
}
