package domain;

import vo.CarName;
import vo.Position;

public class Car {
    public static final int MIN_REQUIRED_POWER = 3;

    private final CarName carName;
    private Position position;

    private Car(CarName carName) {
        this.carName = carName;
        this.position = Position.of(0L);
    }

    public static Car of(String name) {
        CarName carName = CarName.of(name);
        return new Car(carName);
    }

    public String getName() {
        return carName.getValue();
    }

    public Position getPosition() {
        return position;
    }

    public void move(int power) {
        if (power > MIN_REQUIRED_POWER) {
            position = position.plus();
        }
    }

    public boolean hasPosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + carName +
                ", position=" + position +
                '}';
    }
}
