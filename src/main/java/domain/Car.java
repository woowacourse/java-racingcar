package domain;

import java.util.Optional;

public class Car {
    private static final int POWER_LOWER_BOUND = 4;
    private CarName carName;
    private int position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void move(int power) {
        if (power >= POWER_LOWER_BOUND) {
            position++;
        }
    }

    public Optional<String> getNameIfMax(int max) {
        if(position == max) {
            return Optional.of(carName.getName());
        }
        return Optional.empty();
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }
}
