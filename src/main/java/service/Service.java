package service;

import domain.Car;

public class Service {

    private static int RANDOM_NUMBER_RANGE = 10;
    private static int MOVE_BOUNDARY_NUMBER = 4;

    public static void moveForward(Car car) {
        if (willMove()) {
            car.move();
        }
    }

    private static boolean willMove() {
        int randomNumber = (int) (Math.random() * RANDOM_NUMBER_RANGE);
        return randomNumber >= MOVE_BOUNDARY_NUMBER;
    }
}
