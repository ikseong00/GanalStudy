package org.example.hongjun.baekJoon.no1259;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        while(true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            list.add(num);
        }

        Iterator<Integer> iterator = list.iterator();

        while(iterator.hasNext()) {
            int num = iterator.next();
            check(num);
        }
    }

    public static void check(int n) {
        String str = String.valueOf(n);
        int count = 0;

        for(int i = 0; i < (str.length() / 2); i++) {
            if(str.charAt(i) == str.charAt(str.length()-i-1)) {
                count++;
            }
        }

        if(count == (str.length() / 2)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}