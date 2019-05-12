package domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int position;

    Car(final String name) {
        this.name = name;
        this.position = 0;
    }

    boolean isMove(int randomNumber) {
        return randomNumber >= MOVE_CONDITION;
    }

    void move(int randomNumber) {
        if (isMove(randomNumber)) {
            position++;
        }
    }

    boolean isEqualPosition(Car car) {
        return this.position == car.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
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
    public int compareTo(Car o) {
        return Integer.compare(o.position, this.position);
    }
}
