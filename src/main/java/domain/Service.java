package domain;

import java.util.Random;

public class Service {
    public Service() {
    }

    public String[] separateCarName(String carNames) {
        return carNames.split(",");
    }

    public int randomNumberGenerator() {
        Random random = new Random();
        return random.nextInt(9);
    }

    public void goOrStop(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.incLocation();
        }
    }
}