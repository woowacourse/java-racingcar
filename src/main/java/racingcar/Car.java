package racingcar;

import static constant.Constants.CAR_NAME_LIMIT_EXCEPTION;

public class Car {
    private static final int START_POSITION = 0;
    private static final int NAME_MAXIMUM_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, START_POSITION);
    }

    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (isCorrectLength(name)) {
            throw new IllegalArgumentException(CAR_NAME_LIMIT_EXCEPTION);
        }
    }

    private boolean isCorrectLength(String name) {
        return name.isEmpty() || name.length() > NAME_MAXIMUM_LENGTH;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
