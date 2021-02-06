package racingcar.domain;

public class Car {
    private static final String NAME_LENGTH_ERROR_MSG_FORMAT = "이름은 %d자 이상 %d자 미만이어야 합니다";
    private static final int ZERO = 0;
    private static final int MAX_LENGTH = 5;
    private static final int MOVABLE_VALUE = 5;

    private int position;
    private final String name;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = ZERO;
    }

    private void validateNameLength(String name) {
        if (name.length() == ZERO || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(NAME_LENGTH_ERROR_MSG_FORMAT, ZERO, MAX_LENGTH));
        }
    }

    public void move(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    public boolean isSamePosition(int thatPosition) {
        return this.position == thatPosition;
    }

    private boolean isMovable(int number) {
        return number >= MOVABLE_VALUE;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
