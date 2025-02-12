package org.example.hongjun.lotto;

import java.util.List;

public class Printer {
    public static void printStr(String str) {
        System.out.println(str);
    }

    public static void printMoneyStr() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
    }

    public static void printLotto(List<Integer> lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.size() - 1; i++) {
            System.out.print(lotto.get(i) + ", ");
        }
        System.out.print(lotto.getLast());
        System.out.println("]");
    }

    public static void printResult(String[] prizeMoney, int[] rank) {
        int[] count = {3, 4, 5, 5, 6};
        for (int i = 0; i < prizeMoney.length; i++) {
            String str = (i != prizeMoney.length - 2) ? "개 일치 (" : "개 일치, 보너스 볼 일치 (";
            System.out.println(count[i] + str + prizeMoney[i] + "원) - " + rank[i] + "개");
        }
    }

    public static void printError(String errorMessage) {
        printStr("[ERROR] " + errorMessage + "\n");
    }
}
