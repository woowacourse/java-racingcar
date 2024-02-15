package domain;

import java.util.Optional;
import utils.RandomNumberGenerator;

public class Car {
    private CarName carName;
    private int position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void move() {
        int randomNumber = RandomNumberGenerator.generate();
        if (randomNumber >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public Optional<String> getNameIfMax(int max) {
        if(position == max) {
            return Optional.of(carName.getName());
        }
        return Optional.empty();
    }
}
