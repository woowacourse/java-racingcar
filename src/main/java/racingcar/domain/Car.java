package racingcar.domain;

public class Car {
    private static final String NAME_LENGTH_ERROR_MSG_FORMAT = "[ERROR] 이름은 %d자 초과 %d자 이하이어야 합니다. 오류 이름 : %s";
    private static final int ZERO = 0;
    private static final int MAX_LENGTH = 5;
    private static final int MOVABLE_VALUE = 5;
    private final String name;
    private int position;

    public Car(String name) {
        name = name.trim();
        validateNameLength(name);
        this.name = name;
        this.position = ZERO;
    }

    private void validateNameLength(String name) {
        if (name.length() == ZERO || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(NAME_LENGTH_ERROR_MSG_FORMAT, ZERO, MAX_LENGTH, name));
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
