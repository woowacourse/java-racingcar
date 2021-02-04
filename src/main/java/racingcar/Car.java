package racingcar;

import racingcar.exception.InvalidCarNameLengthException;

public class Car {

    private String name;

    public Car(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new InvalidCarNameLengthException();
        }

        this.name = name;
    }
}
