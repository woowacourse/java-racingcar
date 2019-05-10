package model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int MOVE_BOUND = 4;
    private final String name;
    private int position;

    public Car(CarName carName) {
        this.name = carName.getName();
    }

    public Car(CarName carName, int position) {
        this.name = carName.getName();
        this.position = position;
    }

    String getName() {
        return name;
    }

    void move(int number) {
        if (isMove(number)) {
            this.position++;
        }
    }

    private boolean isMove(int number) {
        return number >= MOVE_BOUND;
    }

    public boolean isMaxPosiotion(int maxPosition) {
        return this.position == maxPosition;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return position == car.position &&
                name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" : ");
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }
        return sb.append("/n").toString();
    }
}
