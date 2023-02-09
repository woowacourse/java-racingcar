package racingcar.domain.car;

import java.util.Objects;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
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
        return name.length() > 5 || name.length() < 1;
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
