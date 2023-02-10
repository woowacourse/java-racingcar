package racingcar.domain.car;

import java.util.Objects;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final int MAXIMUM_NUMBER_OF_CHARACTERS = 5;
    private static final int MINIMUM_NUMBER_OF_CHARACTERS = 1;

    private final String name;
    private int position;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    private void validateCarName(String name) {
        if (!isLetter(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 영어로만 구성되어야 합니다.");
        }
        if (isOutOfWordLimit(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 한 글자 이상 다섯 글자 이하여야 합니다.");
        }
    }

    private boolean isOutOfWordLimit(String name) {
        return name.length() > MAXIMUM_NUMBER_OF_CHARACTERS || name.length() < MINIMUM_NUMBER_OF_CHARACTERS;
    }

    private boolean isLetter(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public void move() {
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
