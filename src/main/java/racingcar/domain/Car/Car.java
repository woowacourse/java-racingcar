package racingcar.domain.Car;

import java.util.stream.IntStream;

public class Car {
    private int position;
    private final CarName carName;

    public Car(final String name) {
        this.position = 1;
        this.carName = new CarName(name);
    }

    public void drive(int randomValue) {
        if (randomValue < 0 || randomValue > 9) {
            throw new RuntimeException();
        }

        if (randomValue >= 4) {
            accelerate();
        }
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    private void accelerate() {
        position++;
    }

    private String getPositionToString() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, position)
                .forEach(i -> sb.append("-"));
        return sb.toString();
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