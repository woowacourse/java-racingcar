package racingcar.domain.car;

public class Car {

    private static final int BOUNDARY_NUMBER = 4;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    private final Name name;
    private Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = Position.init();
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void move(final int number) {
        validateRange(number);
        position = nextPosition(number);
    }

    private Position nextPosition(final int number) {
        if (number >= BOUNDARY_NUMBER) {
            return position.increase();
        }
        return position;
    }

    private void validateRange(final int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException();
        }
    }
}
