package org.example.haneul.lotto;

import java.util.List;

public class Printer {
    public void print(String text) {
        System.out.println(text);
    }

    public void printStart() {
        System.out.println("구입금액을 입력해주세요");
    }

    public void printAmount(int amount) {
        System.out.println(amount+"개를 구매했습니다.");
    }

    public void printInput() {
        System.out.println("당첨번호를 입력해주세요.");
    }

    public void printBonus() {
        System.out.println("보너스 번호를 입력해주세요.");
    }


    public void printError(Exception e) {
        System.out.println("[ERROR]"+e.getMessage());
    }

    public void printError(){
        System.out.println("[ERROR] 올바른 입력 요함");
    }

    public void printLotto(Lotto lotto){
        List<Integer> list1=lotto.lottoes.stream().sorted().toList();
        System.out.println(list1);
    }

    public void printResult(){
        System.out.println("당첨 통계\n---\n");
    }

    public void printResult(int i, int j, int k, boolean b){
        String str;
        if (!b){
            str=i+"개 일치 ("+j+"원) - "+k+"개";
        }else str=i+"개 일치, 보너스볼 일치 ("+j+"원) - "+k+"개";
        System.out.println(str);
    }

}
