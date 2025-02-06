package org.example.haneul.lotto;

import java.util.List;

public class Printer {
    public void print(String text) {
        System.out.println(text);
    }

    public void printError(){
        System.out.println("[ERROR]");
    }
    public void printLotto(List<Integer> list){
        List<Integer> list1=list.stream().sorted().toList();
        System.out.println(list1);
    }
    public void printResult(int i, int j, int k){
        String str;
        str=i+"개 일치 ("+j+"원) - "+k+"개";
        System.out.println(str);
    }
}
