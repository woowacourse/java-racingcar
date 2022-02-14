package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final String ERROR_MESSAGE_NAME_LENGTH = "자돋차 이름의 길이는 1 ~ 5 사이여야 합니다.";
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MINIMUM_DRIVE_CONDITION = 4;
    private static final int DEFAULT_POSITION_VALUE = 0;

    private final String name;
    private int position = DEFAULT_POSITION_VALUE;

    public Car(String name) {
        isValidateCarName(name);
        this.name = name;
    }

    private void isValidateCarName(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH || name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NAME_LENGTH);
        }
    }

    public void drive(int value) {
        if (MINIMUM_DRIVE_CONDITION <= value) {
            this.position++;
        }
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Car))
            return false;
        Car car = (Car)o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
