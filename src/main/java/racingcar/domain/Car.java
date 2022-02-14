package racingcar.domain;

import static racingcar.util.CarNameValidationUtil.*;

public class Car {

    private final String name;
    private int position;

    private final int MIN_LENGTH_OF_NAME = 1;
    private final int MAX_LENGTH_OF_NAME = 5;
    private final int CONDITION_FOR_MOVE = 4;

    public Car(String name, int position) {
        validateCarName(name, MIN_LENGTH_OF_NAME, MAX_LENGTH_OF_NAME);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveOrNot(int targetNumber) {
        if (targetNumber >= CONDITION_FOR_MOVE) {
            position++;
        }
    }

    public boolean isSamePosition(int target) {
        return position == target;
    }

}
