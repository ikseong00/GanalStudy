package org.example.seoyeon.lotto;

public class CostUnitException extends IllegalArgumentException {
    public CostUnitException() {
        super("Please enter the purchase amount (unit: " + LottoValue.COST.value+ "won)");
    }
}
