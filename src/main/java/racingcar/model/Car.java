package racingcar.model;

import java.util.List;

public class Car {
    private static final int MINIMUM_POSITION = 0;
    private static final int MOVE_FORWARD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, MINIMUM_POSITION);
    }

    public Car(String name, int position) {
        validateCarNameLength(name);
        this.name = name;
        this.position = position;
    }

    public void move(int value) {
        if (canMove(value)) {
            position++;
        }
    }

    private boolean canMove(int value) {
        return value >= MOVE_FORWARD;
    }

    private void validateCarNameLength(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    public boolean isCarPositionMax(int max) {
        return position == max;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
