package org.example.hongjun.programmers.memoriesScore;

public class Solution {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {
            int yearningSum = 0; // i번째 사진의 그리움 점수 합
            // i번째 사진의 j번째 사람이 name 배열에 있으면 점수 추가
            for (int j = 0; j < photo[i].length; j++) {
                for (int nameIndex = 0; nameIndex < name.length; nameIndex++) {
                    if (name[nameIndex].equals(photo[i][j])) {
                        yearningSum += yearning[nameIndex];
                        break;
                    }
                }
            }
            answer[i] = yearningSum;
        }

        return answer;

    }
}
