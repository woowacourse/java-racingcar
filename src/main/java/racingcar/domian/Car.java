package racingcar.domian;

import java.util.Objects;

public class Car {
    private int position;
    private String name;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public void move(int inputValue) {
        if (inputValue >= 4) {
            this.position++;
        }
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
        return Objects.hash(position, name);
    }

    public int getPosition() {
        return this.position;
    }

    public String findWinner(int max) {
        if (isMaxPosition(max)) {
            return name;
        }
        return "";
    }

    public boolean isMaxPosition(int max) {
        return this.position == max;
    }

    public String getName() {
        return name;
    }
}
