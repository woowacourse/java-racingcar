package domain;

import util.Constants;
import util.Exceptions;

import static util.Constants.MIN_FORWARD_NUMBER;

public class Car {
    private final String name;
    private int forward;

    public Car(String name) {
        validate(name);

        this.name = name;
        this.forward = 0;
    }

    private void validate(String name){
        validateCarNameLength(name);
        validateNameFormat(name);
    }

    private void validateCarNameLength(String name) {
        if (name.length() > Constants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Exceptions.MAX_NAME_EXCEPTION.getMessage());
        }
    }

    private void validateNameFormat(String name) {
        if(name.contains(" ")) {
            throw new IllegalArgumentException(Exceptions.NAME_FORMAT_EXCEPTION.getMessage());
        }
    }

    public void drive(int randomNumber) {
        if (checkForward(randomNumber)) {
            forward += 1;
        }
    }

    private boolean checkForward(int randomNumber) {
        return randomNumber >= MIN_FORWARD_NUMBER;
    }

    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }

}
