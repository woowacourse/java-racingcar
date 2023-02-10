package racingcar.domain.car;

import java.util.Objects;

public class Car {

    public static final String ENGLISH_FORMAT = "[a-zA-Z]+";
    public static final int MAXIMUM_ROUND = 5;
    public static final int MINIMUM_ROUND = 1;
    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    private void validate(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 영어로만 구성되어야 합니다.");
        }
        if (isOutOfRange(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 한 글자 이상 다섯 글자 이하여야 합니다.");
        }
    }

    private boolean isOutOfRange(String name) {
        return name.length() > MAXIMUM_ROUND || name.length() < MINIMUM_ROUND;
    }

    private boolean isValidName(String name) {
        return name.matches(ENGLISH_FORMAT);
    }

    public void updatePosition() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
