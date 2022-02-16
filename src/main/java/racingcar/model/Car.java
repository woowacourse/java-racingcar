package racingcar.model;

import static racingcar.utils.validator.CarNamesValidator.*;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_FORWARD_CONDITION = 4;

    private final String name;
    private int position;

    public Car(final String name) {
        validateCarName(name);
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public String getCarName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isMaxPosition(int max) {
        return position == max;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_CONDITION) {
            position++;
        }
    }
}
