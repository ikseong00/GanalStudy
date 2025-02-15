package org.example.seoyeon.lotto;

public class OutOfLotteryCountException extends IllegalArgumentException {
    public OutOfLotteryCountException() {
        super("Please enter " + LottoValue.NUMBER.value + " numbers.");
    }
}
