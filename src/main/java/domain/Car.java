package domain;

import exception.InputCarNameRangeException;

public class Car {
    private final String name;
    private int position;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MOVE_FORWERD_NUMBER = 4;

    public Car(String name) {
        validationCarNameLength(name);
        this.name = name;
        position = 0;
    }

    public void move(int power) {
        if (power>=MOVE_FORWERD_NUMBER) {
            this.position++;
        }
    }


    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void validationCarNameLength(String carName) throws IllegalArgumentException {
        if (carName.length() > MAX_CAR_NAME_LENGTH || carName.length() < MIN_CAR_NAME_LENGTH) {
            throw new InputCarNameRangeException();
        }
    }

}
