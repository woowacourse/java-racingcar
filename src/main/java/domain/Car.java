package domain;

import dto.CarStatus;

public class Car {

    public static final int INITIAL_DISTANCE = 0;

    private final RandomNumberGenerator randomNumberGenerator;
    private final String name;
    
    private int distance;

    public Car(RandomNumberGenerator randomNumberGenerator, final String name) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.name = name;
        this.distance = INITIAL_DISTANCE;
    }

    public Car(RandomNumberGenerator randomNumberGenerator, final String name, final int distance) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.name = name;
        this.distance = distance;
    }

    public void move() {
        int randomNumber = randomNumberGenerator.generateRandomNumberInRange(0, 9);

        if (randomNumber >= 4) {
            distance++;
        }
    }

    public CarStatus getStatus() {
        return new CarStatus(name, distance);
    }
}
