package racingcar.domain.car;

import java.util.Objects;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final int MAXIMUM_NUMBER_OF_CHARACTERS = 5;
    private static final int MINIMUM_NUMBER_OF_CHARACTERS = 1;

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    private void validate(String name) {
        if (!isValidateName(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 영어로만 구성되어야 합니다.");
        }
        if (isOutOfRange(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 한 글자 이상 다섯 글자 이하여야 합니다.");
        }
    }

    private boolean isOutOfRange(String name) {
        return name.length() > MAXIMUM_NUMBER_OF_CHARACTERS || name.length() < MINIMUM_NUMBER_OF_CHARACTERS;
    }

    private boolean isValidateName(String name) {
        return name.matches("[a-zA-Z]+");
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
