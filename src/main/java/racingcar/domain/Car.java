package racingcar.domain;

import static racingcar.constants.GameConstants.CAN_GO_VALUE;
import static racingcar.constants.SystemConstants.NUMBER_ONE_FOR_INCREMENT;
import static racingcar.constants.GameConstants.INITIAL_POSITION;
import static racingcar.util.ValidatorUtils.validateCarName;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public void goOrNot(int number) {
        if (canGo(number)) {
            go();
        }
    }

    private void go() {
        position += NUMBER_ONE_FOR_INCREMENT;
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
