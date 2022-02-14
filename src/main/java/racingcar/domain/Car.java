package racingcar.domain;

import static racingcar.util.CarNameValidationUtil.*;

public class Car {

    private final String name;
    private int position = 0;

    private final String SIGN_OF_POSITION = "-";
    private final int MIN_LENGTH_OF_NAME = 1;
    private final int MAX_LENGTH_OF_NAME = 5;
    private final int CONDITION_FOR_MOVE = 4;

    public Car(String name) {
        validateCarName(name, MIN_LENGTH_OF_NAME, MAX_LENGTH_OF_NAME);
        this.name = name;
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

    @Override
    public String toString() {
        String positionSign = SIGN_OF_POSITION.repeat(position);
        return (name + " : " + positionSign + "\n");
    }

}
