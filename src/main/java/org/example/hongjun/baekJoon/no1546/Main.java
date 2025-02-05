package org.example.hongjun.baekJoon.no1546;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double max;
        double avg = 0.0;

        int n = scanner.nextInt();

        if ((n > 1000) || (n < 0)) {
            System.out.println("과목 수 잘못됨");
            return;
        }

        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        max = arr[0];

        for (double score : arr) {
            if (score > max) {
                max = score;
            }
        }

        if (max != 0) {
            for (int i = 0; i < n; i++) {
                arr[i] = arr[i] / max * 100;
            }

            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
            }
            avg = sum / n;
        }

        System.out.println(avg);
    }
}
