package domain;

import exception.ErrorMessage;
import exception.RacingCarGameException;

public class CarName {
    private static final int NAME_LENGTH_UPPER_BOUND = 5;
    private String name;

    public CarName(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if(name.length() > NAME_LENGTH_UPPER_BOUND) {
            throw RacingCarGameException.from(ErrorMessage.INVALID_NAME_ERROR);
        }
    }

    public String getName() {
        return name;
    }
}
