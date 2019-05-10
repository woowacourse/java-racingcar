package domain;

import java.util.Objects;

public class Car {
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int position;

    public Car(final String name) {
        this.name = name;
        this.position = 0;
    }

    void move(int randomNumber) {
        if (isMove(randomNumber)) {
            position++;
        }
    }

    static boolean isMove(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }

    int getLargePosition(int largePosition) {
        return Math.max(largePosition, position);
    }

    boolean compareToPosition(int maxPosition) {
        return maxPosition == position;
    }

    private String getPositionString() {
        StringBuilder str = new StringBuilder();

        for (int i = 1; i <= position; i++) {
            str.append("-");
        }

        return str.toString();
    }

    public String appendCarName(String carNames) {
        return carNames + (name + ", ");
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

    @Override
    public String toString() {
        return name + " : " + getPositionString();
    }
}
