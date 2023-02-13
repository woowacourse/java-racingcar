package engine;

import domain.Car;
import domain.Cars;
import utils.RandomNumberGenerator;

public class CarEngine {

    public static void moveCar(Cars cars) {
        for (Car car : cars.getCars()) {
            doRace(car);
        }
    }

    private static boolean canMove() {
        return RandomNumberGenerator.generateRandomNumber() >= 4;
    }

    private static void doRace(final Car car) {
        if (canMove()) {
            car.move();
        }
    }
}
