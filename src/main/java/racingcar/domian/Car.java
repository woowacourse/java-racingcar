package racingcar.domian;

import java.util.Objects;

public class Car {
    private int position;

    public Car() {
        this(0);
    }

    public Car(int position) {
        this.position = position;
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
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getPosition() {
        return this.position;
    }
}
