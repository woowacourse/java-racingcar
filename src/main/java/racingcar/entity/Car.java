package racingcar.entity;

import static racingcar.util.RandomUtil.checkMoveOrWait;
import static racingcar.util.VerificationUtil.validateCarName;

public class Car {

    private static final int INITIAL_VALUE = 0;

    private final String name;
    private int position = INITIAL_VALUE;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void progress(){
        if (checkMoveOrWait()) {
            position++;
        }
    }

    public boolean isWinner(int maxPosition) {
        if (this.position == maxPosition) {
            return true;
        }
        return false;
    }
}
