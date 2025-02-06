package org.example.jaein.baekJoon.no1546;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N;
        while (true) {
            N = sc.nextInt();
            if (1 <= N && N <= 1000) {
                break;
            }
        }

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        int M = 0;
        for (int score : scores) {
            if (score > M) {
                M = score;
            }
        }
        double sum = 0;
        for (int score : scores) {
            sum += (double) score / M * 100;
        }
        double average = sum / N;

        System.out.printf("%.2f\n", average);

        sc.close();
    }
}
