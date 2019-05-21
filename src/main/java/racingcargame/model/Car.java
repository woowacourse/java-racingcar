package racingcargame.model;

import java.util.Objects;

public class Car {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        checkNameLength(name);
        this.name = name;
    }
    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    private static void checkNameLength(String name) {
        if (name.isEmpty() || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void updateCarPosition(int randomNumber) {
        position += randomNumber;
    }

    public String getCarState() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(":");
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public int findMax(int max) {
        if (position > max) {
            max = position;
        }
        return max;
    }

    public boolean isMax(int max) {
        if (position == max) {
            return true;
        }
        return false;
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

    public String getName() {
        return name;
    }
}
