package racingcar.domain.car;

import java.util.Objects;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final String ENGLISH_FORMAT = "[a-zA-Z]+";
    private static final int MAXIMUM_ROUND = 5;
    private static final int MINIMUM_ROUND = 1;
    private static final int MOVING_BOUND = 4;

    private final String name;
    private int position;

    public Car(final String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(final String name, final int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    private void validate(final String name) {
        if (isInvalidFormat(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 영어로만 구성되어야 합니다.");
        }
        if (isOutOfRange(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 한 글자 이상 다섯 글자 이하여야 합니다.");
        }
    }

    private boolean isOutOfRange(final String name) {
        return name.length() > MAXIMUM_ROUND || name.length() < MINIMUM_ROUND;
    }

    private boolean isInvalidFormat(final String name) {
        return !name.matches(ENGLISH_FORMAT);
    }

    public void move(final int power) {
        if (isMovable(power)) {
            position++;
        }
    }

    private boolean isMovable(final int power) {
        return power >= MOVING_BOUND;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
