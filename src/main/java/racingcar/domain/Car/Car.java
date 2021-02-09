package racingcar.domain.Car;

import java.util.stream.IntStream;

public class Car {
    private final int ACCELERATE_THRESHOLD = 4;
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 9;

    private int position;
    private final CarName carName;

    public Car(final String name) {
        this.position = 1;
        this.carName = new CarName(name);
    }

    public void drive(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new RuntimeException("0과 9사이의 값이어야만 합니다.");
        }

        if (value >= ACCELERATE_THRESHOLD) {
            accelerate();
        }
    }

    private void accelerate() {
        position++;
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                ", carName=" + carName +
                '}';
    }

    @Override
    public int hashCode() {
        return carName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return this.carName.equals(car.carName);
        }
        return false;
    }
}