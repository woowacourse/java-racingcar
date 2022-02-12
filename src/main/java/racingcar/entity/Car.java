package racingcar.entity;

import static racingcar.util.VerificationUtil.validateCarName;

public class Car {

    private final String name;
    private int position = 0;
    private final int CAR_NAME_MIN_LENGTH = 1;
    private final int CAR_NAME_MAX_LENGTH = 5;
    private final int CONDITION_FOR_MOVE = 4;

    public Car(String name) {
        validateCarName(name, CAR_NAME_MIN_LENGTH, CAR_NAME_MAX_LENGTH);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveOrNot(int randomNumber) {
        if (randomNumber >= CONDITION_FOR_MOVE) {
            position++;
        }
    }

    @Override
    public String toString() {
        String positionSign = "-".repeat(position);
        return (name + " : " + positionSign + "\n");
    }

}
