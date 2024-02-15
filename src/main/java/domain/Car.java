package domain;

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
}
