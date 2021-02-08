package racingcar.domain;

import racingcar.validator.NameValidator;
import racingcar.utils.RandomUtils;

public class Car {

    private static final int TRY_NUMBER_MIN = 0;
    private static final int TRY_NUMBER_MAX = 9;
    private static final int MOVE_CONDITION = 4;

    private final String name;

    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car createByName(String name) {
        NameValidator.checkValidName(name);
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isInWinnerPosition(int winnerPosition) {
        return winnerPosition == this.position;
    }

    public void tryToMove() {
        int rand = RandomUtils.nextInt(TRY_NUMBER_MIN, TRY_NUMBER_MAX);
        if (rand >= MOVE_CONDITION) {
            movePosition();
        }
    }

    public void movePosition() {
        position++;
    }

    private String getPositionBar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return name + " : " + getPositionBar();
    }
}
