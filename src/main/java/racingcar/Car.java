package racingcar;

import java.util.*;

public class Car {
    private static final int MAX_NAME_SIZE = 5;
    private static final int POSSIBLE_MOVE_CAR = 4;

    private final String name;
    private int position = 0;

    Car(String name) {
        if (isWhiteSpaceOnly(name)) {
            throw new IllegalArgumentException();
        }
        if (isOverLimit(name)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static boolean isWhiteSpaceOnly(String name) {
        return name.isEmpty();
    }

    public static boolean isOverLimit(String name) {
        return name.length() > MAX_NAME_SIZE;
    }

    public Car moveCar(int randomNumber) {
        if (randomNumber >= POSSIBLE_MOVE_CAR) {
            position++;
        }
        return this;
    }

    public int findMax(int max) {
        if (position > max) {
            max = position;
        }
        return max;
    }

    public String sameMaxPositionCarName(int maxPosition) {
        if (this.position == maxPosition) {
            return this.name;
        }
        return null;
    }

    public String getCarState() {
        String carState = this.name + " : ";
        for (int i = 0; i < this.position; i++) {
            carState += "-";
        }
        return carState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
