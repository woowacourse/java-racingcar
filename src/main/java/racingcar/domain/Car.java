package racingcar.domain;

import static racingcar.constants.SystemConstants.CAN_GO_VALUE;
import static racingcar.constants.SystemConstants.INCREMENT_VALUE;
import static racingcar.constants.SystemConstants.INITIAL_POSITION;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public void goOrNot(int number) {
        if (canGo(number)) {
            go();
        }
    }

    private void go() {
        position += INCREMENT_VALUE;
    }

    private boolean canGo(int number) {
        return number >= CAN_GO_VALUE;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
