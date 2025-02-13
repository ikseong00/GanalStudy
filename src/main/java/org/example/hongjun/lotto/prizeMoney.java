package org.example.hongjun.lotto;

public enum prizeMoney {
    FIRST_PLACE(5000),
    SECOND_PLACE(50000),
    THIRD_PLACE(1500000),
    FOURTH_PLACE(30000000),
    FIFTH_PLACE(2000000000);

    private final int money;

    prizeMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
