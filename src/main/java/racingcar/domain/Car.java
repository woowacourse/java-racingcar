package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private static final int OPERATING_STANDARD = 4;

    private String name;
    private int position;

    public Car(String carName, int position) {
        this.name = carName;
        this.position = position;
    }

    public void tryMovingBy(RandomNumberGenerator randomNumberGenerator) {
        if (isMovableBy(randomNumberGenerator)) {
            position++;
        }
    }

    public boolean isMovableBy(RandomNumberGenerator randomNumberGenerator) {
        return randomNumberGenerator.generate() >= OPERATING_STANDARD;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return position;
    }
}
