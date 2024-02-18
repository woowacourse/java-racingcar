package domain;

import domain.car.Car;

import java.util.function.IntSupplier;

public class RandomMovingCar {
    private static final int MIN_POWER = 0;
    private static final int MAX_POWER = 9;
    private static final int POWER_THRESHOLD = 4;
    private static final int DRIVE_FORWARD_DISTANCE = 1;

    private final Car car;
    private final IntSupplier powerGenerator;

    public RandomMovingCar(Car car, IntSupplier powerGenerator) {
        this.car = car;
        this.powerGenerator = powerGenerator;
    }

    public void move() {
        int power = powerGenerator.getAsInt();

        if (power >= POWER_THRESHOLD) {
            car.move(DRIVE_FORWARD_DISTANCE);
        }
    }

    public boolean isSamePosition(int maxPosition) {
        return car.isSamePosition(maxPosition);
    }

    public static int generateRandomPower() {
        return (int) (Math.random() * (MAX_POWER - MIN_POWER + 1) + MIN_POWER);
    }

    public String getName() {
        return car.getName();
    }

    public int getPosition() {
        return car.getPosition();
    }
}
