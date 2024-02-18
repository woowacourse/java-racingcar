package domain;

import dto.CarStatus;
import java.util.Optional;

public class Car {
    private static final int POWER_LOWER_BOUND = 4;
    private CarName carName;
    private int position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = 0;
    }

    public CarStatus move(int power) {
        if (power >= POWER_LOWER_BOUND) {
            position++;
        }
        return new CarStatus(carName.getName(), position);
    }

    public Optional<String> getNameIfSamePosition(int target) {
        if(position == target) {
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
