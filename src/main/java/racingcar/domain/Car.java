package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    public static final int CAR_NAME_MIN_LENGTH = 1;
    public static final int CAR_NAME_MAX_LENGTH = 5;
    public static final String ERROR_INVALID_CAR_NAME_LENGTH_MESSAGE = 1 + "~" + 5 + " 글자 범위 내에서 입력하세요.";
    private static final int MINIMUM_DRIVE_CONDITION = 4;
    private static final int DEFAULT_POSITION_VALUE = 0;
    private final String name;
    private int position = DEFAULT_POSITION_VALUE;

    private Car(String name) {
        this.name = name;
    }

    public static Car fromName(String carName) {
        validateCar(carName);
        return new Car(carName);
    }

    private static void validateCar(String carName) {
        checkValidLengthOfCarName(carName);
    }

    private static void checkValidLengthOfCarName(String carName) {
        int carNameLength = carName.length();
        if (!(CAR_NAME_MIN_LENGTH <= carNameLength && carNameLength <= CAR_NAME_MAX_LENGTH)) {
            throw new IllegalArgumentException(ERROR_INVALID_CAR_NAME_LENGTH_MESSAGE);
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

    public int toPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Car)) {
            return false;
        }
        Car car = (Car) object;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }


}
