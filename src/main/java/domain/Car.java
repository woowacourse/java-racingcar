package domain;

import util.Constants;

import static util.Constants.MIN_FORWARD_NUMBER;
import static util.Exceptions.MAX_NAME_EXCEPTION;

public class Car {
    private final String name;
    private int forward;

    public Car(String name) {
        validateCarNameLength(name);
        this.name = name;
        this.forward = 0;
    }

    private void validateCarNameLength(String name) {
        if (name.length() > Constants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_NAME_EXCEPTION.getMessage());
        }
    }

    //TODO:number 변수명 변경하기
    public void drive(int number) {
        if(checkForward(number)) {
            forward += 1;
        }
    }

    private boolean checkForward(int number) {
        return number >= MIN_FORWARD_NUMBER;
    }

}
