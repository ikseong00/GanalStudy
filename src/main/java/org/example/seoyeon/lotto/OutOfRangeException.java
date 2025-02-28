package org.example.seoyeon.lotto;

public class OutOfRangeException extends IllegalArgumentException {
    public OutOfRangeException() {
        super("Please enter the number "+ LottoValue.MIN.value +" ~ " + LottoValue.MAX.value);
    }
}
