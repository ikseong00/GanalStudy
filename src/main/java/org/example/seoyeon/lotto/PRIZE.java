package org.example.seoyeon.lotto;

public enum PRIZE {
    FIRST_PRIZE("2,000,000,000"),
    SECOND_PRIZE("30,000,000"),
    THIRD_PRIZE("1,500,000"),
    FORTH_PRIZE("50,000"),
    FIFTH_PRIZE("5,000");

    String prize;

    PRIZE(String prize) {
        this.prize = prize;
    }
}
