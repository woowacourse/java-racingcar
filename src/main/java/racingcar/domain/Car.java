package racingcar.domain;

public class Car {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int DEFAULT_FORWARD = 0;
    private static final int MOVE_STEP = 1;
    private final String name;
    private int forward;

    Car(final String name) {
        validate(name);
        this.name = name;
        forward = DEFAULT_FORWARD;
    }

    private void validate(final String name) {
        if (isLongerThanMaxLength(name)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isLongerThanMaxLength(final String name) {
        return name.length() > CAR_NAME_MAX_LENGTH;
    }

    public void move(final CarMoveStrategy carMoveStrategy, final int value) {
        if (carMoveStrategy.isMovable(value)) {
            forward += MOVE_STEP;
        }
    }

    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }
}
