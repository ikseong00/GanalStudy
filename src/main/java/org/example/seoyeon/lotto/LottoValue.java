package org.example.seoyeon.lotto;

public enum LottoValue {
    COST(1000),
    MAX(45),
    NUMBER(6),
    BONUS(1),
    MIN(1);

    int value;

    LottoValue(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
