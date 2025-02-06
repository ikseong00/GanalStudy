package org.example.jaein.lotto;

//import java.util.ArrayList;

public class Printer {
    public static void printStr(String str) {
        System.out.println(str);
    }

    public static void printError(Exception e) {
        printStr("[ERROR]" + e.getMessage());
    }
    public static void printLottoAmount(int lottoAmount) {
        System.out.println(lottoAmount+"개를 구매했습니다.");
    }

    public static void printLottoList(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printLottoResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - ");
        System.out.println("4개 일치 (50,000원) - ");
        System.out.println("5개 일치 (1,500,000원) - ");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
        System.out.println("6개 일치 (2,000,000,000원) - ");
        System.out.println("총 수익률은 62.5%입니다.");
    }
}
