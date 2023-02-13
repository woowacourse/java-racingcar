package racingcar.domain.car;

import racingcar.domain.game.NumberGenerator;

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

    public Name name() {
        return name;
    }

    public Position position() {
        return position;
    }

    public void move(final NumberGenerator numberGenerator) {
        int number = numberGenerator.generate(MIN_RANGE, MAX_RANGE);
        validateRange(number);
        position = nextPosition(number);
    }

    private void validateRange(final int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    private Position nextPosition(final int number) {
        if (number >= BOUNDARY_NUMBER) {
            return position.increase();
        }
        return position;
    }

    public boolean isSamePosition(final Car car) {
        return this.position.equals(car.position);
    }
}
