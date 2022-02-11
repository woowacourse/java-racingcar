package racingcar.domain;

public class Car {
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
            throw new IllegalArgumentException();
        }

        if (name.length() > NAME_LIMITED_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        if (movingPolicy.isMove()) {
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
