package org.example.hongjun.programmers.videoPlayer;

public class Solution {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int videoSecond = getSecond(video_len); // 영상 길이
        int posSecond = getSecond(pos); // 현재 위치
        int opStartSecond = getSecond(op_start); // 오프닝 시작
        int opEndSecond = getSecond(op_end); // 오프닝 끝

        if ((posSecond < opEndSecond) && (posSecond >= opStartSecond)) {
            posSecond = opEndSecond;
        }

        for (String command : commands) {
            if (command.equals("prev")) {
                posSecond -= 10;
                if (posSecond < 0) {
                    posSecond = 0;
                }
            } else if (command.equals("next")) {
                posSecond += 10;
                if (posSecond > videoSecond) {
                    posSecond = videoSecond;
                }
            }
            if ((posSecond < opEndSecond) && (posSecond >= opStartSecond)) {
                posSecond = opEndSecond;
            }
        }

        int minute = posSecond / 60;
        if (minute < 10) {
            answer += "0" + minute + ":";
        } else {
            answer += minute + ":";
        }

        int second = posSecond % 60;
        if (second < 10) {
            answer += "0" + second;
        } else {
            answer += second;
        }

        return answer;
    }

    // mm:ss -> 정수 초로 변환
    private int getSecond(String time) {
        String[] times = time.split(":");
        int minute = Integer.parseInt(times[0]);
        int second = Integer.parseInt(times[1]);
        return minute * 60 + second;
    }

}
