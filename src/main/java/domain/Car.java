package domain;

import util.Constants;
import util.Exceptions;

public class Car {

    private final String name;
    private int forward;

    public Car(String name) {
        validateCarNameLength(name);
        validateNameFormat(name);

        this.name = name;
        this.forward = 0;
    }

    private void validateCarNameLength(String name) {
        if (name.length() > Constants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Exceptions.MAX_NAME_EXCEPTION.getMessage());
        }
    }

    private void validateNameFormat(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(Exceptions.NAME_FORMAT_EXCEPTION.getMessage());
        }
    }

    public void drive(int randomNumber) {
        if (checkCanDrive(randomNumber)) {
            forward += 1;
        }
    }

    private boolean checkCanDrive(int randomNumber) {
        return randomNumber >= Constants.MIN_FORWARD_NUMBER;
    }

    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }

}
