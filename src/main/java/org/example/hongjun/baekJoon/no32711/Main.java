package org.example.hongjun.baekJoon.no32711;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        if (sum % 2 == 0) {
            check(arr);
        } else {
            System.out.println(1);
        }

    }

    private static void check(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i % 2 == 1) {
                count++;
            }
        }

        if(count == 0) {
            if(arr.length == 1) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        } else if (count == 2) {
            if((arr[0] % 2 == 1) && (arr[arr.length - 1] % 2 == 1)) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        } else {
            System.out.println(1);
        }
    }

}
