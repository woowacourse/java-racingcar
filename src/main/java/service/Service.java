package service;

import domain.Car;

public class Service {

    public static void moveForward(Car car) {
        if (willMove()) {
            car.move();
        }
    }

    private static boolean willMove() {
        int randomNumber = (int) (Math.random() * 10);
        return randomNumber >= 4;
    }
}
