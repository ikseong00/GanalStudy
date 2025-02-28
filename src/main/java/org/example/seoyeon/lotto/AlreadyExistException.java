package org.example.seoyeon.lotto;

public class AlreadyExistException extends IllegalArgumentException {
    public AlreadyExistException(int num) {
        super("The number "+num+" is already existed.");
    }
}
