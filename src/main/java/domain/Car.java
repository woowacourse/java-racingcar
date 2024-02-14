import util.Constants;

import static util.Exceptions.MAX_NAME_EXCEPTION;

public class Car {
    private final String name;
    private final int forward;

    public Car(String name) {
        validateCarNameLength(name);
        this.name = name;
        this.forward = 0;
    }

    private void validateCarNameLength(String name) {
        if (name.length() > Constants.MAX_NAME_LENGTH){
            throw new IllegalArgumentException(MAX_NAME_EXCEPTION.getMessage());
        }
    }

}
