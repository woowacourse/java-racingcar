package racingcar.domain;

import racingcar.Validation;

public class Car {

    private static final int MOVING_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int movingCondition) {
        if (movingCondition >= MOVING_CONDITION) {
            position++;
        }
    }

    public int findGreaterPosition(int position) {
        return Math.max(this.position, position);
    }

    public boolean isSamePosition(int winnerPosition) {
        return winnerPosition == position;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return name + " : " + "-".repeat(Math.max(0, position));
    }
}
