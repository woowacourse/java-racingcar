package racingcar.domain;

public class Car {
    private final String name;
    private int position;
    private MovingPolicy movingPolicy;

    public Car(String name, MovingPolicy movingPolicy) {
        validateNull(name);
        validateEmpty(name);
        validateBlank(name);
        validateNameLength(name);
        this.name = name;
        this.position = 0;
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
        if (name.length() > 5) {
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
