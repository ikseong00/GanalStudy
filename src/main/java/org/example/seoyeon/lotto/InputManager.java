package org.example.seoyeon.lotto;

public class InputManager {
    static int moneyInput(String str) {
        String moneyStr = str.replaceAll("[ ,]|won|원", "");
        if (moneyStr.indexOf("십") == 0) {
            moneyStr = moneyStr.replace("십", "10");
        } else {
            moneyStr = moneyStr.replace("십", "0");
        }
        if (moneyStr.indexOf("백") == 0) {
            moneyStr = moneyStr.replace("백", "100");
        } else {
            moneyStr = moneyStr.replace("백", "00");
        }
        if (moneyStr.indexOf("천") == 0) {
            moneyStr = moneyStr.replace("천", "1000");
        } else {
            moneyStr = moneyStr.replace("천", "000");
        }
        if (moneyStr.indexOf("만") == 0) {
            moneyStr = moneyStr.replace("만", "10000");
        } else {
            moneyStr = moneyStr.replace("만", "0000");
        }
        moneyStr = moneyStr.replace("일", "1");
        moneyStr = moneyStr.replace("이", "2");
        moneyStr = moneyStr.replace("삼", "3");
        moneyStr = moneyStr.replace("사", "4");
        moneyStr = moneyStr.replace("오", "5");
        moneyStr = moneyStr.replace("육", "6");
        moneyStr = moneyStr.replace("칠", "7");
        moneyStr = moneyStr.replace("팔", "8");
        moneyStr = moneyStr.replace("구", "9");

        int money = Integer.parseInt(moneyStr);

        return money;
    }


}
