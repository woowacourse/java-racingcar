package racingcar.domain;

public class Car {

    private static final int NAME_LIMITED_LENGTH = 5;
    private static final int POSITION_INIT = 0;

    private final String name;
    private int position;
    private MovingPolicy movingPolicy;

    public Car(String name, MovingPolicy movingPolicy) {
        validateNull(name);
        validateEmpty(name);
        validateBlank(name);
        validateNameLength(name);
        this.name = name;
        this.position = POSITION_INIT;
        this.movingPolicy = movingPolicy;
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LIMITED_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void move() {
        if(movingPolicy.isMove()) {
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
