package racingcar.domain;

public class Car {
    private static final String NAME_INPUT_ERROR = "이름은 공백, 빈 값, null일 수 없습니다.";
    private static final String NAME_LENGTH_ERROR = "이름은 5자를 초과할 수 없습니다.";

    private static final int NAME_LIMITED_LENGTH = 5;
    private static final int POSITION_INIT = 0;

    private final String name;
    private int position;
    private final MovingPolicy movingPolicy;

    public Car(String name, MovingPolicy movingPolicy) {
        validateName(name);
        this.name = name;
        this.position = POSITION_INIT;
        this.movingPolicy = movingPolicy;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException(NAME_INPUT_ERROR);
        }

        if (name.length() > NAME_LIMITED_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    public void move() {
        if (movingPolicy.isMovable()) {
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
