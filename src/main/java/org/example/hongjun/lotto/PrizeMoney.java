package org.example.hongjun.lotto;

public enum PrizeMoney {
    FIRST_PLACE(5000, 3),
    SECOND_PLACE(50000, 4),
    THIRD_PLACE(1500000, 5),
    FOURTH_PLACE(30000000, 5),
    FIFTH_PLACE(2000000000, 6);

    private final int money; // 상금
    private final int count; // 일치 개수

    PrizeMoney(int money, int count) {
        this.money = money;
        this.count = count;
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }
}
