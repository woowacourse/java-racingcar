package racingcar.entity;

import static racingcar.util.VerificationUtil.validateCarName;

public class Car {

    private static final int INITIAL_VALUE = 0;
    private static final int PROGRESS_CONDITION_VALUE = 4;

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

    public void progress(int number){
        if (number >= PROGRESS_CONDITION_VALUE) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        if (this.position == position) {
            return true;
        }
        return false;
    }
}

